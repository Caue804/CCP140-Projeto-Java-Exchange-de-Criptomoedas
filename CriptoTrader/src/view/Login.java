
package view;

import controller.ControleLogin;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends javax.swing.JFrame {
    public Login() {
        initComponents();
        c = new ControleLogin(this);
    }

    public JPanel getAux_pnl() {
        return aux_pnl;
    }

    public void setAux_pnl(JPanel aux_pnl) {
        this.aux_pnl = aux_pnl;
    }

    public JLabel getCpf_lbl() {
        return cpf_lbl;
    }

    public void setCpf_lbl(JLabel cpf_lbl) {
        this.cpf_lbl = cpf_lbl;
    }

    public JTextField getCpf_txt() {
        return cpf_txt;
    }

    public void setCpf_txt(JTextField cpf_txt) {
        this.cpf_txt = cpf_txt;
    }

    public JButton getEnter_bt() {
        return enter_bt;
    }

    public void setEnter_bt(JButton enter_bt) {
        this.enter_bt = enter_bt;
    }

    public JLabel getSenha_lbl() {
        return senha_lbl;
    }

    public void setSenha_lbl(JLabel senha_lbl) {
        this.senha_lbl = senha_lbl;
    }

    public JPasswordField getSenha_txt() {
        return senha_txt;
    }

    public void setSenha_txt(JPasswordField senha_txt) {
        this.senha_txt = senha_txt;
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public void setTitulo(JLabel titulo) {
        this.titulo = titulo;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aux_pnl = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        cpf_lbl = new javax.swing.JLabel();
        cpf_txt = new javax.swing.JTextField();
        senha_lbl = new javax.swing.JLabel();
        senha_txt = new javax.swing.JPasswordField();
        enter_bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        aux_pnl.setBackground(new java.awt.Color(200, 200, 200));
        aux_pnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        aux_pnl.setPreferredSize(new java.awt.Dimension(300, 400));

        titulo.setBackground(new java.awt.Color(100, 100, 100));
        titulo.setFont(new java.awt.Font("Swis721 BlkCn BT", 3, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("CriptoTrader");
        titulo.setToolTipText("");

        cpf_lbl.setText(" CPF (Apenas Numeros)");

        cpf_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpf_txtActionPerformed(evt);
            }
        });

        senha_lbl.setText(" Senha ");

        senha_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senha_txtActionPerformed(evt);
            }
        });

        enter_bt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        enter_bt.setText("ENTRAR");
        enter_bt.setToolTipText("");
        enter_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enter_btActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout aux_pnlLayout = new javax.swing.GroupLayout(aux_pnl);
        aux_pnl.setLayout(aux_pnlLayout);
        aux_pnlLayout.setHorizontalGroup(
            aux_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aux_pnlLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(enter_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aux_pnlLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(aux_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aux_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(aux_pnlLayout.createSequentialGroup()
                            .addComponent(cpf_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aux_pnlLayout.createSequentialGroup()
                            .addComponent(cpf_lbl)
                            .addGap(127, 127, 127)))
                    .addGroup(aux_pnlLayout.createSequentialGroup()
                        .addGroup(aux_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(senha_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(senha_lbl))
                        .addContainerGap())))
        );
        aux_pnlLayout.setVerticalGroup(
            aux_pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aux_pnlLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(cpf_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpf_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(senha_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senha_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(54, 54, 54)
                .addComponent(enter_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        getContentPane().add(aux_pnl, new java.awt.GridBagConstraints());

        setSize(new java.awt.Dimension(736, 519));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cpf_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpf_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpf_txtActionPerformed

    private void enter_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enter_btActionPerformed
        c.validarLogin(cpf_txt.getText(), new String(senha_txt.getPassword()));
    }//GEN-LAST:event_enter_btActionPerformed

    private void senha_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senha_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senha_txtActionPerformed

    private ControleLogin c;
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aux_pnl;
    private javax.swing.JLabel cpf_lbl;
    private javax.swing.JTextField cpf_txt;
    private javax.swing.JButton enter_bt;
    private javax.swing.JLabel senha_lbl;
    private javax.swing.JPasswordField senha_txt;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
