package controller;

import dao.InvestidorDAO;
import dao.Conexao;
import model.Investidor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import view.Login;
import view.Dashboard;

public class ControleLogin {
    
    private Login tela1;

    public ControleLogin(Login tela1) {
        this.tela1 = tela1;
    }

    public void validarLogin(String cpf, String senha) {
        Investidor investidor = new Investidor();
        investidor.setCpf(cpf);
        investidor.setSenha(senha);

        try {
            Connection conn = Conexao.getConnection();
            InvestidorDAO investidorDAO = new InvestidorDAO(conn);
            ResultSet res = investidorDAO.consultar(investidor);

            if (res.next()) {
                // Login bem-sucedido
                JOptionPane.showMessageDialog(tela1, "Login Feito!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                Dashboard dashboard = new Dashboard(cpf); // Passa as info do investidor para o Dashboard
                dashboard.setVisible(true);  // Abre o Dashboard
                tela1.setVisible(false);    //  Fecha o Login
            } else {
                // Login inválido
                JOptionPane.showMessageDialog(tela1, "Login não efetuado", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela1, 
            "Erro de Conexão", 
            "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}