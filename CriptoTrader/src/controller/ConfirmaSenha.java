package controller;
 
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import model.Investidor;
 

public class ConfirmaSenha {
    
    //bool -> V/F ; passa componente pro pop-up e o investidor para validar a senha dele 
    // (nao precisa do banco pois o objeto ja existe)

    public static boolean confirmar(Component telaSenha, Investidor investidor) {
        JPasswordField campo = new JPasswordField();
 
        int opcao = JOptionPane.showConfirmDialog(telaSenha,
                new Object[]{"Digite sua senha (6 dígitos):", campo},
                "Confirmação de senha",
                JOptionPane.OK_CANCEL_OPTION, //botão de cancelar
                JOptionPane.PLAIN_MESSAGE);


        // cancelou ou fechou o pop-up
        if (opcao != JOptionPane.OK_OPTION) {
            return false; 
        }
 
        String digitada = new String(campo.getPassword());
 
        if (!digitada.equals(investidor.getSenha())) {
            JOptionPane.showMessageDialog(telaSenha, 
                "Senha incorreta!", 
                "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}