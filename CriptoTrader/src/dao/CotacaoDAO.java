package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Moedas;

public class CotacaoDAO {

    private Connection conn;

    public CotacaoDAO(Connection conn) {
        this.conn = conn;
    }


    // Busca a cotacao atual no banco pelo simbolo ('BTC', 'ETH' ou 'XRP')

    public double buscarCotacao(String simbolo) throws SQLException {
        String sql = "SELECT valor_reais FROM cotacao WHERE moeda = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, simbolo);
        
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getDouble("valor_reais");
        }
        return 0.0;
    }


    // Salva a nova cotacao no banco

    public void salvarCotacao(Moedas moeda) throws SQLException {
        String sql = "UPDATE cotacao SET valor_reais = ? WHERE moeda = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, moeda.getCotacao());
        statement.setString(2, moeda.getNome()); // Deve ser "BTC", "ETH" ou "XRP"
        statement.executeUpdate();
    }
}