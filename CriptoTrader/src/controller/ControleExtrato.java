package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import dao.Conexao;
import dao.OperacaoDAO;
import java.util.List;
import model.Investidor;
import model.Operacao;
import view.Extrato;


public class ControleExtrato {

    private Extrato view;
    private Investidor investidor;

    public ControleExtrato(Extrato view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
        gerarExtratoLista(); 
    }

    private void gerarExtratoLista() {
        try {
            Connection conn = new Conexao().getConnection();
            OperacaoDAO dao = new OperacaoDAO(conn);
            
            // Busca as operações do banco desse cpf
            List<Operacao> lista = dao.listarPorCpf(investidor.getCpf());
            //cabeçalho do extrato
            StringBuilder sb = new StringBuilder();
            sb.append("Nome: ").append(investidor.getNome()).append("\n");
            sb.append("CPF: ").append(investidor.getCpf()).append("\n\n");
            
            // Percorre a lista de operações e aplica a formatação exata da imagem
            for (Operacao op : lista) {
                // Formato de data: DD-MM-YYYY HH:MM
                String dataFormatada = op.getDataHora().toString()
                        .replace("T", " ")                      
                        .substring(0, 16); // Pega até os minutos (HH:MM)
                
                // Formatação principal semelhante à imagem
                sb.append(String.format("| %s   | %c   | %9.2f   | %-4s   | CT: %7.2f   | TX: %4.2f   | REAL: %10.2f   | BTC: %7.4f   | ETH: %7.4f   | XRP: %6.1f  |\n",
                    dataFormatada, 
                    op.getTipo(), 
                    op.getQuantidade(), //troca moeda e quantidade de lugar
                    op.getMoeda(),      //troca moeda e quantidade de lugar
                    op.getCotacao(), 
                    op.getTaxa(), 
                    op.getCarteira().getSaldoReais(), 
                    op.getCarteira().getSaldoBitcoin(), 
                    op.getCarteira().getSaldoEthereum(), 
                    op.getCarteira().getSaldoRipple()
                ));
            }

            view.getTxtExtrato().setText(sb.toString());
            view.getTxtExtrato().setCaretPosition(0);

            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, 
                "Erro ao carregar o extrato: " + e.getMessage(), 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
