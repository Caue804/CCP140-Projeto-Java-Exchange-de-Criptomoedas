package controller;

import dao.Conexao;
import dao.InvestidorDAO;
import dao.OperacaoDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import model.Carteira;
import model.Investidor;
import model.Operacao;
import view.Extrato;

/** Monta o extrato do investidor no formato pedido na especificação. */
public class ControleExtrato {

    private static final DateTimeFormatter DATA = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    private final Extrato tela;
    private final String cpf;

    public ControleExtrato(Extrato tela, String cpf) {
        this.tela = tela;
        this.cpf = cpf;
        carregar();
    }

    private void carregar() {
        try (Connection conn = Conexao.getConnection()) {
            Investidor investidor = new InvestidorDAO(conn).buscarPorCpf(cpf);
            List<Operacao> operacoes = new OperacaoDAO(conn).listarPorCpf(cpf);

            tela.getTxtExtrato().setText(montarTexto(investidor.getNome(), investidor.getCpf(), operacoes));
            tela.getTxtExtrato().setCaretPosition(0);   // começa pelo topo
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao carregar o extrato: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ================== Formatação ==================

    static String montarTexto(String nome, String cpf, List<Operacao> operacoes) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("CPF: ").append(formatarCpf(cpf)).append("\n\n");

        if (operacoes.isEmpty()) {
            sb.append("Nenhuma operação registrada.");
        }
        for (Operacao op : operacoes) {
            Carteira c = op.getCarteira();
            boolean emReais = op.getMoeda().equals("REAL");
            // Locale.US para sair com ponto decimal, como no exemplo da especificação
            sb.append(String.format(Locale.US, "%s %c %s %s CT: %s TX: %.2f REAL: %.2f BTC: %s ETH: %s XRP: %s%n",
                    op.getDataHora().format(DATA),
                    op.getSinal(),
                    emReais ? String.format(Locale.US, "%.2f", op.getValor()) : numero(op.getValor(), 2),
                    op.getMoeda(),
                    numero(op.getCotacao(), 1),
                    op.getTaxa(),
                    c.getSaldoReais(),
                    numero(c.getSaldoBitcoin(), 1),
                    numero(c.getSaldoEthereum(), 1),
                    numero(c.getSaldoRipple(), 1)));
        }
        return sb.toString();
    }

    // Número sem notação científica e com no mínimo "minCasas" casas (ex.: 0.0058, 16108.0)
    private static String numero(double valor, int minCasas) {
        BigDecimal b = BigDecimal.valueOf(valor).stripTrailingZeros();
        if (b.scale() < minCasas) {
            b = b.setScale(minCasas);
        }
        return b.toPlainString();
    }

    // 12345678900 -> 123.456.789-00
    private static String formatarCpf(String cpf) {
        if (cpf != null && cpf.matches("\\d{11}")) {
            return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "."
                 + cpf.substring(6, 9) + "-" + cpf.substring(9);
        }
        return cpf;
    }
}
