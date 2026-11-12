package controller;

import dao.Conexao;
import dao.InvestidorDAO;
import dao.OperacaoDAO;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import model.Carteira;
import model.Investidor;

import view.Caixa;
import view.Dashboard;


public class ControleCaixa {

    private static final double LIMITE = 999999999.99;

    private  Caixa tela;
    private  Dashboard dashboard;
    private  String cpf;
    private  Investidor investidorLogado;

    public ControleCaixa(Caixa tela, Investidor investidorLogado, Dashboard dashboard) {
        this.tela = tela;
        this.investidorLogado = investidorLogado;
        this.dashboard = dashboard;
        this.cpf = investidorLogado.getCpf();
        exibirSaldo(investidorLogado.getCarteira().getSaldoReais());
    }

    // O saldo aparece nas duas abas
    private void exibirSaldo(double saldo) {
        tela.getLblValorSaldoDeposito().setText(brl(saldo));
        tela.getLblValorSaldoSaque().setText(brl(saldo));
    }

    // ================== Ações chamadas pela view ==================

    public void depositar() {
        movimentar(true, tela.getFtxtValorDeposito());
    }

    public void sacar() {
        movimentar(false, tela.getFtxtValorSaque());
    }

    // Retorna o investidor logado para outras telas que precisarem
    public Investidor getInvestidorLogado() {
        return investidorLogado;
    }


    // ================== Fluxo comum de depósito e saque ==================

    private void movimentar(boolean deposito, JFormattedTextField campo) {
        
        double valor = Math.round(ValidaCampos.lerNumero(campo) * 100.0) / 100.0;
        
        //valor errado
        if (valor <= 0 || valor > LIMITE) {
            erro("Digite um valor válido");
            campo.setValue(null); 
            return;
        }
        //valor certo
        try {
            Investidor atualizado = executar(deposito, valor);
            Connection conn = Conexao.getConnection();
            
            if (atualizado == null) {
                erro("Saldo insuficiente para este saque!");
                return;
            }

            double saldo = atualizado.getCarteira().getSaldoReais();
            exibirSaldo(saldo);
            campo.setValue(null);          // limpa o campo
            dashboard.atualizarSaldos();   // atualiza os saldos do Dashboard

            JOptionPane.showMessageDialog(tela,
                    (deposito ? "Depósito" : "Saque") + " de " + brl(valor) + " realizado com sucesso!\n"
                    + "Novo saldo: " + brl(saldo));

        } catch (SQLException e) {
            erro("Erro ao acessar o banco de dados: " + e.getMessage());
        }
    }

    private Investidor executar(boolean deposito, double valor) throws SQLException {
        try (Connection conn = Conexao.getConnection()) {
            conn.setAutoCommit(false);
            try {
                InvestidorDAO dao = new InvestidorDAO(conn);

                Carteira carteira = investidorLogado.getCarteira();
                boolean ok = deposito ? carteira.depositar(valor) : carteira.sacar(valor);
                if (!ok) {
                    conn.rollback();
                    return null;
                }

                dao.atualizar(investidorLogado);
                new OperacaoDAO(conn).registrar(cpf, deposito ? '+' : '-', "REAL", valor, 0.0, 0.0, valor, carteira);

                conn.commit();
                return investidorLogado;

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }

    // ================== Auxiliares ==================

    private static String brl(double valor) {
        return String.format("R$ %,.2f", valor);
    }

    private void erro(String mensagem) {
        JOptionPane.showMessageDialog(tela, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
