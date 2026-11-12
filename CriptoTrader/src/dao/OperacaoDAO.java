package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Carteira;
import model.Operacao;

/** Grava e lê as operações da carteira (alimenta o extrato). */
public class OperacaoDAO {
    private Connection conn;

    public OperacaoDAO(Connection conn) {
        this.conn = conn;
    }

    //Registra uma nova operação. A carteira deve ser a de DEPOIS da operação.
    public void registrar(String cpf, 
                            char sinal,   
                            String moeda, 
                            double quantidade,
                            double cotacao, 
                            double taxa, 
                            double valorReais,
                            Carteira carteira) throws SQLException {
            
        String sql = "INSERT INTO operacao " + 
                        "(cpf_usuario, data_hora, tipo, moeda, quantidade, cotacao_unitaria, taxa, valor_reais, " + 
                        "saldo_reais, saldo_bitcoin, saldo_ethereum, saldo_ripple) " +
                        "VALUES (?, CURRENT_TIMESTAMP, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, cpf);
        statement.setString(2, String.valueOf(sinal));
        statement.setString(3, moeda);
        statement.setDouble(4, quantidade);
        statement.setDouble(5, cotacao);
        statement.setDouble(6, taxa);
        statement.setDouble(7, valorReais);
        statement.setDouble(8, carteira.getSaldoReais());
        statement.setDouble(9, carteira.getSaldoBitcoin());
        statement.setDouble(10, carteira.getSaldoEthereum());
        statement.setDouble(11, carteira.getSaldoRipple());
        
        statement.executeUpdate();
        // Não fechar a conexão (conn.close()) para permitir transações com rollback no Controller
    }

    // Busca  as operações do cpf, da mais antiga para a mais recente
    public List<Operacao> listarPorCpf(String cpf) throws SQLException {
        String sql = "SELECT data_hora, tipo, moeda, quantidade, cotacao_unitaria, taxa, valor_reais, " +
                        "saldo_reais, saldo_bitcoin, saldo_ethereum, saldo_ripple " +
                        "FROM operacao WHERE cpf_usuario = ? ORDER BY data_hora ASC, id ASC";

        List<Operacao> lista = new ArrayList<>();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, cpf);
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            Carteira carteira = new Carteira(
                    rs.getDouble("saldo_reais"),
                    rs.getDouble("saldo_bitcoin"),
                    rs.getDouble("saldo_ethereum"),
                    rs.getDouble("saldo_ripple")
            );
            
            lista.add(new Operacao(
                    rs.getTimestamp("data_hora").toLocalDateTime(),
                    rs.getString("tipo").charAt(0),
                    rs.getString("moeda"),
                    rs.getDouble("quantidade"),
                    rs.getDouble("cotacao_unitaria"),
                    rs.getDouble("taxa"),
                    carteira
            ));            
        }
        return lista;
    }
}