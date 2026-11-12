package controller;

import dao.Conexao;
import dao.CotacaoDAO;
import dao.InvestidorDAO;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;


import model.Investidor;
import model.Bitcoin;
import model.Ethereum;
import model.Ripple;

import view.Dashboard;

public class ControleDashboard {
    
    private Dashboard tela;
    private String cpfLogado;             // CPF do investidor que logou
    private Investidor investidorLogado;  // Objeto Investidor que sera montado com o cpf

    // ================== Construtor ==================
    //(precisa da tela que vai controlar e o cpf de quem logou para puxar os dados)

    public ControleDashboard(Dashboard tela, String cpfLogado) {
        this.tela = tela;
        this.cpfLogado = cpfLogado;
        carregarDadosInvestidor();
    }

    // ================== Getter ==================

    public Investidor getInvestidorLogado() {
       return investidorLogado;
    }

    // ================== Métodos ==================
    // Consulta os dados do usuário logado e monta o objeto

    // Público porque Caixa e Trade chamam (via Dashboard.atualizarSaldos) depois de cada operação
    public void carregarDadosInvestidor() {
        try (Connection conn = Conexao.getConnection()) {
            Investidor investidor = new InvestidorDAO(conn).buscarPorCpf(this.cpfLogado);

            if (investidor != null) {
                this.investidorLogado = investidor;

                // Atualiza os textos das labels
                tela.getLblNome().setText("Bem vindo: " + investidor.getNome());
                tela.getLblCpf().setText("CPF: " + investidor.getCpf());
                tela.getLblSaldoReais().setText(String.format("R$ %.2f", investidor.getCarteira().getSaldoReais()));
                tela.getLblSaldoBtc().setText(String.format("%.4f", investidor.getCarteira().getSaldoBitcoin()));
                tela.getLblSaldoEth().setText(String.format("%.4f", investidor.getCarteira().getSaldoEthereum()));
                tela.getLblSaldoXrp().setText(String.format("%.4f", investidor.getCarteira().getSaldoRipple()));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela,
                "Erro ao carregar os dados do investidor: " + e.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizarCotacoes() {
        try (Connection conn = Conexao.getConnection()) {
            CotacaoDAO dao = new CotacaoDAO(conn);

            // Valores atuais das cotações no banco de dados
            Bitcoin btc = new Bitcoin(dao.buscarCotacao("BTC"));
            Ethereum eth = new Ethereum(dao.buscarCotacao("ETH"));
            Ripple xrp = new Ripple(dao.buscarCotacao("XRP"));

            // Armazena os valores ANTES da variação
            double btcAntigo = btc.getCotacao();
            double ethAntigo = eth.getCotacao();
            double xrpAntigo = xrp.getCotacao();

            // Variação aleatória de -5% a +5% da classe abstyrata
            btc.atualizarCotacao();
            eth.atualizarCotacao();
            xrp.atualizarCotacao();

            // Salva as novas cotacoes
            dao.salvarCotacao(btc);
            dao.salvarCotacao(eth);
            dao.salvarCotacao(xrp);

            //Mensagem que vai no aviso sobre quanto variou
            String mensagem = String.format(
                "Cotações atualizadas com sucesso!\n\n" +
                "BTC (%.2f%%):   R$ %.2f  =>  R$ %.2f \n" +
                "ETH (%.2f%%):   R$ %.2f  =>  R$ %.2f \n" +
                "XRP (%.2f%%):   R$ %.2f  =>  R$ %.2f",
                ((btc.getCotacao() - btcAntigo) / btcAntigo) * 100, btcAntigo, btc.getCotacao(),
                ((eth.getCotacao() - ethAntigo) / ethAntigo) * 100, ethAntigo, eth.getCotacao(), 
                ((xrp.getCotacao() - xrpAntigo) / xrpAntigo) * 100, xrpAntigo, xrp.getCotacao() 
            );

            
        // SUCESSO
            JOptionPane.showMessageDialog(tela, 
                mensagem, 
                "Aviso", JOptionPane.INFORMATION_MESSAGE);
            
        // ERRO
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, 
                "Erro ao atualizar cotações: " + e.getMessage(), 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

