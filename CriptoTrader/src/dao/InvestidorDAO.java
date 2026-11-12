package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.Investidor;

public class InvestidorDAO {
    private Connection conn;

    public InvestidorDAO(Connection conn) {
        this.conn = conn;
    }

    // Validar Login
    public ResultSet consultar(Investidor investidor) throws SQLException {
        String sql = "SELECT * FROM investidor WHERE cpf = ? AND senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getCpf());
        statement.setString(2, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }

    // Atualiza os saldos na carteira (Depósito, Saque, Compra e Venda)
    public void atualizar(Investidor investidor) throws SQLException {
        String sql = "UPDATE investidor SET saldo_reais = ?, saldo_bitcoin = ?, saldo_ethereum = ?, saldo_ripple = ? WHERE cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getSaldoReais());
        statement.setDouble(2, investidor.getCarteira().getSaldoBitcoin());
        statement.setDouble(3, investidor.getCarteira().getSaldoEthereum());
        statement.setDouble(4, investidor.getCarteira().getSaldoRipple());
        statement.setString(5, investidor.getCpf());
        statement.execute();
        //conn.close();
    }


}