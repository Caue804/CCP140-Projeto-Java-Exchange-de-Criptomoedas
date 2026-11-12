package controller;

import dao.Conexao;
import dao.CotacaoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


import model.Investidor;
import model.Carteira;
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
    }

    // ================== Getter ==================

    // Retorna o investidor logado para outras telas que precisarem
    public Investidor getInvestidorLogado() {
        return investidorLogado;
    }

    // ================== Métodos ==================

    // Consulta os dados do usuário logado e monta o objeto

    public void carregarDadosInvestidor() {
        String sql = "SELECT nome, cpf, senha, saldo_reais, saldo_bitcoin, saldo_ethereum, saldo_ripple FROM investidor WHERE cpf = ?";
        
        try {
            Connection conn = new Conexao().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, this.cpfLogado);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {  
                //Extrai os valores do banco
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String senha = rs.getString("senha");
                double sReais = rs.getDouble("saldo_reais");
                double sBtc = rs.getDouble("saldo_bitcoin");
                double sEth = rs.getDouble("saldo_ethereum");
                double sXrp = rs.getDouble("saldo_ripple");
                
                // Cria a Carteira e instancia o Investidor com os dados e com os saldos do banco
                Carteira carteira = new Carteira(sReais, sBtc, sEth, sXrp);
                this.investidorLogado = new Investidor(nome, cpf, senha, carteira);
                
                // Atualiza os textos das labels
                tela.getLblNome().setText("Bem vindo: " + investidorLogado.getNome());
                tela.getLblCpf().setText("CPF: " + investidorLogado.getCpf());
                tela.getLblSaldoReais().setText(String.format("R$ %.2f", investidorLogado.getCarteira().getSaldoReais()));
                tela.getLblSaldoBtc().setText(String.format("%.4f", investidorLogado.getCarteira().getSaldoBitcoin()));
                tela.getLblSaldoEth().setText(String.format("%.4f", investidorLogado.getCarteira().getSaldoEthereum()));
                tela.getLblSaldoXrp().setText(String.format("%.4f", investidorLogado.getCarteira().getSaldoRipple()));
            }
            
            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, 
                "Erro ao carregar os dados do investidor: " + e.getMessage(), 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void atualizarSaldos() {
        if (investidorLogado != null) {
            tela.getLblSaldoReais().setText(String.format("R$ %.2f", investidorLogado.getCarteira().getSaldoReais()));
            tela.getLblSaldoBtc().setText(String.format("%.4f", investidorLogado.getCarteira().getSaldoBitcoin()));
            tela.getLblSaldoEth().setText(String.format("%.4f", investidorLogado.getCarteira().getSaldoEthereum()));
            tela.getLblSaldoXrp().setText(String.format("%.4f", investidorLogado.getCarteira().getSaldoRipple()));
        }
    }

    public void atualizarCotacoes() {
        try {
            Connection conn = new Conexao().getConnection();
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

            conn.close(); //fecha a comunicação

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

