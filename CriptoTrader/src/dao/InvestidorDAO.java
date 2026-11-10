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
        String sql = "select * from investidor where cpf = ? and senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getCpf());
        statement.setString(2, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }

    // Atualiza os saldos na carteira (Depósito, Saque, Compra e Venda)
    public void atualizar(Investidor investidor) throws SQLException {
        String sql = "update investidor set saldo_reais = ?, saldo_bitcoin = ?, saldo_ethereum = ?, saldo_ripple = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setDouble(1, investidor.getSaldoReais());
//        statement.setDouble(2, investidor.getSaldoBitcoin());
//        statement.setDouble(3, investidor.getSaldoEthereum());
//        statement.setDouble(4, investidor.getSaldoRipple());
        statement.setString(5, investidor.getCpf());
        statement.execute();
        conn.close();
    }


}