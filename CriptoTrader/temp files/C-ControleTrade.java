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

/** Controla a tela Trade: cotações, resumo da ordem e execução de compra/venda. */
public class ControleTrade {

    private static final double LIMITE = 999999999;

    private final Trade tela;
    private final Dashboard dashboard;
    private final String cpf;

    public ControleTrade(Trade tela, String cpf, Dashboard dashboard) {
        this.tela = tela;
        this.cpf = cpf;
        this.dashboard = dashboard;
        carregarCotacoes();
        atualizarResumo();
    }

    // ================== Painel de cotações ==================

    public void carregarCotacoes() {
        try (Connection conn = Conexao.getConnection()) {
            CotacaoDAO dao = new CotacaoDAO(conn);
            tela.getLblValorBtc().setText(brl(dao.buscarCotacao("BTC")));
            tela.getLblValorEth().setText(brl(dao.buscarCotacao("ETH")));
            tela.getLblValorXrp().setText(brl(dao.buscarCotacao("XRP")));
        } catch (SQLException e) {
            erro("Erro ao carregar as cotações: " + e.getMessage());
        }
    }

    // ================== Resumo (subtotal / taxa / total) ==================
    // Chamado ao trocar Comprar/Vender, a moeda ou ao digitar a quantidade

    public void atualizarResumo() {
        boolean compra = tela.isCompra();
        tela.getLblTotal().setText(compra ? "Total a pagar:" : "Total a receber:");

        double qtd = lerQuantidade();
        if (qtd <= 0) {
            limparResumo();
            return;
        }
        try {
            String simbolo = tela.getSimbolo();
            Calculo c = calcular(compra, criarMoeda(simbolo, buscarCotacao(simbolo)), qtd);
            tela.getLblSubtotalValor().setText(brl(c.subtotal));
            tela.getLblTaxa().setText(String.format("Taxa (%.0f%%):", c.percentual));
            tela.getLblTaxaValor().setText(brl(c.taxa));
            tela.getLblTotalValor().setText(brl(c.total));
        } catch (SQLException e) {
            limparResumo();   // enquanto digita, não incomoda o usuário com pop-up
        }
    }

    private void limparResumo() {
        tela.getLblSubtotalValor().setText(brl(0));
        tela.getLblTaxa().setText("Taxa (X%):");
        tela.getLblTaxaValor().setText(brl(0));
        tela.getLblTotalValor().setText(brl(0));
    }

    // ================== Execução da ordem ==================

    public void executarOrdem() {
        boolean compra = tela.isCompra();
        String simbolo = tela.getSimbolo();

        double qtd = lerQuantidade();
        if (qtd <= 0) {
            erro("Digite uma quantidade válida maior que zero. Ex: 0,05");
            return;
        }

        try {
            carregarCotacoes();   // garante que o painel mostra o preço usado na ordem
            Calculo calc = calcular(compra, criarMoeda(simbolo, buscarCotacao(simbolo)), qtd);

            // 1) Valida o saldo antes de pedir a senha (nada é gravado aqui)
            Investidor investidor = carregarInvestidor();
            if (!aplicar(investidor.getCarteira(), compra, simbolo, qtd, calc)) {
                erro(compra ? "Saldo em reais insuficiente para esta compra!"
                            : "Saldo de " + simbolo + " insuficiente para esta venda!");
                return;
            }

            // 2) Confirma a senha
            if (!ConfirmaSenha.confirmar(tela, investidor)) {
                return;
            }

            // 3) Grava
            if (gravar(compra, simbolo, qtd, calc) == null) {
                erro("O saldo mudou e ficou insuficiente. Tente novamente.");
                return;
            }

            tela.getFtxtQuantidade().setValue(null);   // limpa o campo
            atualizarResumo();
            dashboard.atualizarSaldos();
            JOptionPane.showMessageDialog(tela, String.format(
                    "%s realizada com sucesso!\n%s %s a %s\nTaxa: %s\n%s %s",
                    compra ? "Compra" : "Venda",
                    BigDecimal.valueOf(qtd).stripTrailingZeros().toPlainString(), simbolo, brl(calc.cotacao),
                    brl(calc.taxa),
                    compra ? "Total pago:" : "Total recebido:", brl(calc.total)));

        } catch (SQLException e) {
            erro("Erro ao acessar o banco de dados: " + e.getMessage());
        }
    }

    // Aplica a ordem na carteira (a regra está na classe Carteira)
    private boolean aplicar(Carteira carteira, boolean compra, String simbolo, double qtd, Calculo calc) {
        return compra ? carteira.comprar(simbolo, qtd, calc.total)
                      : carteira.vender(simbolo, qtd, calc.total);
    }

    // Salva saldos e registra no extrato na mesma transação. Retorna null se o saldo não bastar.
    private Investidor gravar(boolean compra, String simbolo, double qtd, Calculo calc) throws SQLException {
        try (Connection conn = Conexao.getConnection()) {
            conn.setAutoCommit(false);
            try {
                InvestidorDAO investidorDAO = new InvestidorDAO(conn);
                Investidor investidor = investidorDAO.buscarPorCpf(cpf);
                if (investidor == null) {
                    throw new SQLException("Investidor não encontrado.");
                }
                if (!aplicar(investidor.getCarteira(), compra, simbolo, qtd, calc)) {
                    conn.rollback();
                    return null;
                }
                investidorDAO.atualizar(investidor);
                new OperacaoDAO(conn).registrar(cpf, compra ? '+' : '-', simbolo,
                        qtd, calc.cotacao, calc.taxa, investidor.getCarteira());
                conn.commit();
                return investidor;
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }

    // ================== Cálculo (sem banco) ==================

    static class Calculo {
        final double cotacao, subtotal, taxa, percentual, total;

        Calculo(double cotacao, double subtotal, double taxa, double percentual, double total) {
            this.cotacao = cotacao;
            this.subtotal = subtotal;
            this.taxa = taxa;
            this.percentual = percentual;
            this.total = total;
        }
    }

    // Compra: total = subtotal + taxa | Venda: total = subtotal - taxa
    static Calculo calcular(boolean compra, Moedas moeda, double qtd) {
        Tarifacao tarifa = (Tarifacao) moeda;   // Bitcoin, Ethereum e Ripple implementam Tarifacao
        double subtotal = arredondar(qtd * moeda.getCotacao());
        double taxa = arredondar(compra ? tarifa.calcularTaxaCompra(subtotal)
                                        : tarifa.calcularTaxaVenda(subtotal));
        double percentual = compra ? tarifa.calcularTaxaCompra(100) : tarifa.calcularTaxaVenda(100);
        double total = arredondar(compra ? subtotal + taxa : subtotal - taxa);
        return new Calculo(moeda.getCotacao(), subtotal, taxa, percentual, total);
    }

    // ================== Auxiliares ==================

    // Quantidade digitada (até 8 casas). Retorna -1 se vazia ou inválida.
    private double lerQuantidade() {
        double qtd = Math.round(Campos.lerNumero(tela.getFtxtQuantidade()) * 1e8) / 1e8;
        return (qtd > 0 && qtd <= LIMITE) ? qtd : -1;
    }

    private Moedas criarMoeda(String simbolo, double cotacao) {
        switch (simbolo) {
            case "BTC": return new Bitcoin(cotacao);
            case "ETH": return new Ethereum(cotacao);
            default:    return new Ripple(cotacao);
        }
    }

    private double buscarCotacao(String simbolo) throws SQLException {
        try (Connection conn = Conexao.getConnection()) {
            double cotacao = new CotacaoDAO(conn).buscarCotacao(simbolo);
            if (cotacao <= 0) {
                throw new SQLException("Cotação de " + simbolo + " não encontrada.");
            }
            return cotacao;
        }
    }

    private Investidor carregarInvestidor() throws SQLException {
        try (Connection conn = Conexao.getConnection()) {
            Investidor investidor = new InvestidorDAO(conn).buscarPorCpf(cpf);
            if (investidor == null) {
                throw new SQLException("Investidor não encontrado.");
            }
            return investidor;
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
