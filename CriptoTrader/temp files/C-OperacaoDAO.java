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

    // Registra uma operação. A carteira deve ser a de DEPOIS da operação.
    // sinal: '+' ou '-' | moeda: "REAL", "BTC", "ETH" ou "XRP"
    public void registrar(String cpf, char sinal, String moeda, double valor,
                            double cotacao, double taxa, Carteira carteira) throws SQLException {
        String sql = "insert into operacao (cpf, sinal, moeda, valor, cotacao, taxa, "
                    + "saldo_reais, saldo_bitcoin, saldo_ethereum, saldo_ripple) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cpf);
            statement.setString(2, String.valueOf(sinal));
            statement.setString(3, moeda);
            statement.setDouble(4, valor);
            statement.setDouble(5, cotacao);
            statement.setDouble(6, taxa);
            statement.setDouble(7, carteira.getSaldoReais());
            statement.setDouble(8, carteira.getSaldoBitcoin());
            statement.setDouble(9, carteira.getSaldoEthereum());
            statement.setDouble(10, carteira.getSaldoRipple());
            statement.executeUpdate();
        }
    }

    // Todas as operações do investidor, da mais antiga para a mais recente
    public List<Operacao> listarPorCpf(String cpf) throws SQLException {
        String sql = "select data_hora, sinal, moeda, valor, cotacao, taxa, "
                    + "saldo_reais, saldo_bitcoin, saldo_ethereum, saldo_ripple "
                    + "from operacao where cpf = ? order by data_hora, id";
        List<Operacao> lista = new ArrayList<>();
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cpf);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Carteira carteira = new Carteira(
                            rs.getDouble("saldo_reais"),
                            rs.getDouble("saldo_bitcoin"),
                            rs.getDouble("saldo_ethereum"),
                            rs.getDouble("saldo_ripple"));
                    lista.add(new Operacao(
                            rs.getTimestamp("data_hora").toLocalDateTime(),
                            rs.getString("sinal").charAt(0),
                            rs.getString("moeda"),
                            rs.getDouble("valor"),
                            rs.getDouble("cotacao"),
                            rs.getDouble("taxa"),
                            carteira));
                }
            }
        }
        return lista;
    }
}
