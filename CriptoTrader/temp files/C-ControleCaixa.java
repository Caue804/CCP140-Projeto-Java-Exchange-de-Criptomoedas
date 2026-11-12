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

/** Controla as abas de Depósito e Saque da tela Caixa. */
public class ControleCaixa {

    private static final double LIMITE = 999999999.99;

    private final Caixa tela;
    private final Dashboard dashboard;
    private final String cpf;

    public ControleCaixa(Caixa tela, String cpf, Dashboard dashboard) {
        this.tela = tela;
        this.cpf = cpf;
        this.dashboard = dashboard;
        carregarSaldo();
    }

    // ================== Ações chamadas pela view ==================

    public void depositar() {
        movimentar(true, tela.getFtxtValorDeposito());
    }

    public void sacar() {
        movimentar(false, tela.getFtxtValorSaque());
    }

    // ================== Fluxo comum de depósito e saque ==================

    private void movimentar(boolean deposito, JFormattedTextField campo) {
        double valor = Math.round(Campos.lerNumero(campo) * 100.0) / 100.0;
        if (valor <= 0 || valor > LIMITE) {
            erro("Digite um valor válido maior que zero. Ex: 150,00");
            return;
        }

        try {
            Investidor atualizado = executar(deposito, valor);

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

    /**
     * Aplica a operação na carteira, salva o saldo e registra no extrato, tudo na mesma
     * transação: ou grava as duas coisas, ou nenhuma.
     *
     * @return o investidor com a carteira atualizada, ou null se o saque exceder o saldo
     */
    private Investidor executar(boolean deposito, double valor) throws SQLException {
        try (Connection conn = Conexao.getConnection()) {
            conn.setAutoCommit(false);
            try {
                InvestidorDAO investidorDAO = new InvestidorDAO(conn);

                // Busca o saldo mais recente do banco (outra tela pode ter alterado)
                Investidor investidor = investidorDAO.buscarPorCpf(cpf);
                if (investidor == null) {
                    throw new SQLException("Investidor não encontrado.");
                }

                Carteira carteira = investidor.getCarteira();
                boolean ok = deposito ? carteira.depositar(valor) : carteira.sacar(valor);
                if (!ok) {
                    conn.rollback();
                    return null;
                }

                investidorDAO.atualizar(investidor);
                new OperacaoDAO(conn).registrar(cpf, deposito ? '+' : '-', "REAL",
                        valor, 0.0, 0.0, carteira);

                conn.commit();
                return investidor;

            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }

    // ================== Auxiliares ==================

    // Mostra o saldo atual assim que a tela abre
    private void carregarSaldo() {
        try (Connection conn = Conexao.getConnection()) {
            Investidor investidor = new InvestidorDAO(conn).buscarPorCpf(cpf);
            if (investidor != null) {
                exibirSaldo(investidor.getCarteira().getSaldoReais());
            }
        } catch (SQLException e) {
            erro("Erro ao carregar o saldo: " + e.getMessage());
        }
    }

    // O saldo aparece nas duas abas
    private void exibirSaldo(double saldo) {
        tela.getLblValorSaldoDeposito().setText(brl(saldo));
        tela.getLblValorSaldoSaque().setText(brl(saldo));
    }

    private static String brl(double valor) {
        return String.format("R$ %,.2f", valor);
    }

    private void erro(String mensagem) {
        JOptionPane.showMessageDialog(tela, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
