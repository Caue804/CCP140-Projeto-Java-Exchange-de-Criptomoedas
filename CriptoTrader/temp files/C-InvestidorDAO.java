package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.Carteira;
import model.Investidor;

public class InvestidorDAO {
    private Connection conn;

    public InvestidorDAO(Connection conn) {
        this.conn = conn;
    }

    // Validar Login
    public ResultSet consultar(Investidor investidor) throws SQLException {
        String sql = "select * from investidor where cpf = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getCpf());
        statement.setString(2, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }

    // Busca o investidor com a carteira atualizada pelo CPF (null se não existir)
    public Investidor buscarPorCpf(String cpf) throws SQLException {
        String sql = "select nome, cpf, senha, saldo_reais, saldo_bitcoin, saldo_ethereum, saldo_ripple "
                   + "from investidor where cpf = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cpf);
            try (ResultSet rs = statement.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                Carteira carteira = new Carteira(
                        rs.getDouble("saldo_reais"),
                        rs.getDouble("saldo_bitcoin"),
                        rs.getDouble("saldo_ethereum"),
                        rs.getDouble("saldo_ripple"));
                return new Investidor(rs.getString("nome"), rs.getString("cpf"),
                        rs.getString("senha"), carteira);
            }
        }
    }

    // Atualiza os saldos na carteira (Depósito, Saque, Compra e Venda)
    // Não fecha a conexão: quem abriu (o controller) é quem fecha, para poder usar transação
    public void atualizar(Investidor investidor) throws SQLException {
        String sql = "update investidor set saldo_reais = ?, saldo_bitcoin = ?, saldo_ethereum = ?, saldo_ripple = ? where cpf = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            Carteira carteira = investidor.getCarteira();
            statement.setDouble(1, carteira.getSaldoReais());
            statement.setDouble(2, carteira.getSaldoBitcoin());
            statement.setDouble(3, carteira.getSaldoEthereum());
            statement.setDouble(4, carteira.getSaldoRipple());
            statement.setString(5, investidor.getCpf());
            statement.executeUpdate();
        }
    }

}
