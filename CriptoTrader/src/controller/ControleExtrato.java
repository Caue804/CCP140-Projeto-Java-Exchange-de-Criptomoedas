package controller;

import dao.Conexao;
import dao.OperacaoDAO;
import model.Investidor;
import view.Extrato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleExtrato {

    private Extrato view;
    private Investidor investidor;

    public ControleExtrato(Extrato view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
        gerarExtrato(); // Já carrega e exibe o extrato assim que a tela abre
    }

    private void gerarExtrato() {
        try {
            Connection conn = new Conexao().getConnection();
            OperacaoDAO dao = new OperacaoDAO(conn);
            
            // Busca as operações do banco de dados usando o CPF do investidor logado
            ResultSet rs = dao.consultarExtrato(investidor.getCpf());

            StringBuilder sb = new StringBuilder();
            sb.append("Nome: ").append(investidor.getNome()).append("\n");
            sb.append("CPF: ").append(investidor.getCpf()).append("\n\n");
            
            // Cabeçalho da tabela
            sb.append(String.format("%-19s | %-2s | %-10s | %-5s | %-9s | %-6s | %-10s | %-8s | %-8s | %-8s\n", 
                "DATA/HORA", "OP", "VALOR", "MOEDA", "COTACAO", "TAXA", "REAL", "BTC", "ETH", "XRP"));
            sb.append("-----------------------------------------------------------------------------------------------------------------\n");

            // Percorrendo o ResultSet ou lista de operações vindas do banco
            while (rs.next()) {
                sb.append(String.format("%-19s | %-2s | %10.2f | %-5s | %9.2f | %6.2f | %10.2f | %8.4f | %8.4f | %8.2f\n",
                    rs.getString("data_hora"), 
                    rs.getString("tipo"), 
                    rs.getDouble("valor_reais"), 
                    rs.getString("moeda"), 
                    rs.getDouble("cotacao_unitaria"), 
                    rs.getDouble("taxa"), 
                    rs.getDouble("saldo_reais"), 
                    rs.getDouble("saldo_bitcoin"), 
                    rs.getDouble("saldo_ethereum"), 
                    rs.getDouble("saldo_ripple")));
            }

            // Aplica o texto completo na tela (substitua getTxtExtrato() pelo nome real do seu JTextArea)
            view.getTxtExtrato().setText(sb.toString());
            
            // Retorna a barra de rolagem para o topo
            view.getTxtExtrato().setCaretPosition(0);

            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, 
                "Erro ao carregar o extrato: " + e.getMessage(), 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}