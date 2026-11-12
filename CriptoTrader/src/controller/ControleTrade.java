package controller;

import dao.Conexao;
import dao.CotacaoDAO;
import dao.InvestidorDAO;
import dao.OperacaoDAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import model.Bitcoin;
import model.Carteira;
import model.Ethereum;
import model.Investidor;
import model.Moedas;
import model.Ripple;
import model.Tarifacao;
import view.Dashboard;
import view.Trade;

public class ControleTrade {

    private static final double LIMITE = 999999999.99;

    private final Trade tela;
    private final Dashboard dashboard;
    private final Investidor investidorLogado;

    // Variáveis em memória para armazenar as cotações fixas do banco
    private double cotacaoBTC;
    private double cotacaoETH;
    private double cotacaoXRP;

    public ControleTrade(Trade tela, Investidor investidorLogado, Dashboard dashboard) {
        this.tela = tela;
        this.investidorLogado = investidorLogado;
        this.dashboard = dashboard;
        carregarCotacoes();
    }

    // Retorna o investidor logado para outras telas que precisarem
    public Investidor getInvestidorLogado() {
        return investidorLogado;
    }

    // ================== Cotações (Memória e Banco) ==================

    public void carregarCotacoes() {
        try (Connection conn = new Conexao().getConnection()) {
            CotacaoDAO dao = new CotacaoDAO(conn);
            
            // Busca no banco e salva na memória do Controller
            this.cotacaoBTC = dao.buscarCotacao("BTC");
            this.cotacaoETH = dao.buscarCotacao("ETH");
            this.cotacaoXRP = dao.buscarCotacao("XRP");
            
            tela.getLblValorBtc().setText(brl(cotacaoBTC));
            tela.getLblValorEth().setText(brl(cotacaoETH));
            tela.getLblValorXrp().setText(brl(cotacaoXRP));

        } catch (SQLException e) {
            erro("Erro ao carregar as cotações: " + e.getMessage());
        }
    }

    private double getCotacaoAtual(String simbolo) {
        switch (simbolo) {
            case "BTC": return cotacaoBTC;
            case "ETH": return cotacaoETH;
            case "XRP": return cotacaoXRP;
            default: return 0.0;
        }
    }

    // ================== Resumo Financeiro ==================
    
    public void atualizarResumo(boolean compra, String simbolo, double qtd) {
        //tela.getLblTotal().setText(compra ? "Total a pagar:" : "Total a receber:");

        if (qtd <= 0) {
            limparResumo();
            return;
        }

        // Recupera da memória (instantâneo, sem consultar o banco)
        double cotacao = getCotacaoAtual(simbolo);
        Moedas moedaModel = criarMoeda(simbolo, cotacao); 
        Tarifacao tarifa = (Tarifacao) moedaModel;

        double subtotal = arredondar(qtd * cotacao);
        double taxaValor = arredondar(compra ? tarifa.calcularTaxaCompra(subtotal) : tarifa.calcularTaxaVenda(subtotal));
        double taxaPercentual = compra ? tarifa.calcularTaxaCompra(100) : tarifa.calcularTaxaVenda(100); 
        double total = arredondar(compra ? subtotal + taxaValor : subtotal - taxaValor);
        
        tela.getLblSubtotalValor().setText(brl(subtotal));
        tela.getLblTaxa().setText(String.format("Taxa (%.0f%%):", taxaPercentual));
        tela.getLblTaxaValor().setText(brl(taxaValor));
        tela.getLblTotalValor().setText(brl(total));
    }

    public void limparResumo() {
        tela.getLblSubtotalValor().setText("R$");
        tela.getLblTaxa().setText("Taxa (%):");
        tela.getLblTaxaValor().setText("R$");
        tela.getLblTotal().setText("Total:");
        tela.getLblTotalValor().setText("R$");
    }

    // ================== Execução da Ordem ==================

    public void executarOrdem(boolean compra, String simbolo, double qtd) {
        if (qtd <= 0 || qtd > LIMITE) {
            erro("Digite uma quantidade válida maior que zero.");
            return;
        }

        try {
            double cotacao = getCotacaoAtual(simbolo);
            Moedas moedaModel = criarMoeda(simbolo, cotacao);
            Tarifacao tarifa = (Tarifacao) moedaModel;
            
            double subtotal = arredondar(qtd * cotacao);
            double taxaValor = arredondar(compra ? tarifa.calcularTaxaCompra(subtotal) : tarifa.calcularTaxaVenda(subtotal));
            double totalTransacao = arredondar(compra ? subtotal + taxaValor : subtotal - taxaValor);
            
            Carteira carteira = investidorLogado.getCarteira();

            if (compra && carteira.getSaldoReais() < totalTransacao) {
                erro("Saldo em reais insuficiente para esta compra!");
                return;
            } else if (!compra && obterSaldoCripto(carteira, simbolo) < qtd) {
                erro("Saldo de " + simbolo + " insuficiente para esta venda!");
                return;
            }
/*
            if (!ConfirmaSenha.confirmar(tela, investidorLogado)) {
                return;
            }
*/
            if (compra) {
                carteira.comprar(simbolo, qtd, totalTransacao);
            } else {
                carteira.vender(simbolo, qtd, totalTransacao);
            }

            gravarTransacaoBanco(compra, simbolo, qtd, cotacao, taxaValor, totalTransacao, carteira);

            limparResumo();
            tela.getFtxtValorDeposito().setValue(null);          // limpa o campo
            dashboard.atualizarSaldos();   // atualiza os saldos do Dashboard


            JOptionPane.showMessageDialog(tela, String.format(
                    "%s realizada com sucesso!\n%s %s a %s\nTaxa: %s\n%s %s",
                    compra ? "Compra" : "Venda",
                    BigDecimal.valueOf(qtd).stripTrailingZeros().toPlainString(), simbolo, brl(cotacao),
                    brl(taxaValor),
                    compra ? "Total pago:" : "Total recebido:", brl(totalTransacao)),
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            erro("Erro ao acessar o banco de dados: " + e.getMessage());
        }
    }

    private void gravarTransacaoBanco(boolean compra, String simbolo, double qtd, double cotacao, double taxa, double totalReais, Carteira carteira) throws SQLException {
        try (Connection conn = new Conexao().getConnection()) {
            conn.setAutoCommit(false);
            try {
                InvestidorDAO investidorDAO = new InvestidorDAO(conn);
                investidorDAO.atualizar(investidorLogado);

                OperacaoDAO operacaoDAO = new OperacaoDAO(conn);
                char sinal = compra ? '+' : '-';
                operacaoDAO.registrar(investidorLogado.getCpf(), sinal, simbolo, qtd, cotacao, taxa, totalReais, carteira);

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                
                if (compra) {
                    carteira.vender(simbolo, qtd, totalReais); 
                } else {
                    carteira.comprar(simbolo, qtd, totalReais); 
                }
                throw e;
            }
        }
    }

    // ================== Model Factory e Auxiliares ==================

    private Moedas criarMoeda(String simbolo, double cotacao) {
        switch (simbolo) {
            case "BTC": return new Bitcoin(cotacao);
            case "ETH": return new Ethereum(cotacao);
            case "XRP": return new Ripple(cotacao);
            default: return null;   
        }
    }

    private double obterSaldoCripto(Carteira carteira, String simbolo) {
        switch (simbolo) {
            case "BTC": return carteira.getSaldoBitcoin();
            case "ETH": return carteira.getSaldoEthereum();
            case "XRP": return carteira.getSaldoRipple();
            default: return 0.0;
        }
    }

    private static double arredondar(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

    private static String brl(double v) {
        return String.format("R$ %,.2f", v);
    }

    private void erro(String mensagem) {
        JOptionPane.showMessageDialog(tela, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}