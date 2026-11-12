
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

    private ControleLogin c;

    // ================== Getters ==================

    public JPanel getAux_pnl() {
        return pnlAux;
    }

    public void setAux_pnl(JPanel aux_pnl) {
        this.pnlAux = aux_pnl;
    }

    public JLabel getCpf_lbl() {
        return lblCpf;
    }

    public void setCpf_lbl(JLabel cpf_lbl) {
        this.lblCpf = cpf_lbl;
    }

    public JTextField getCpf_txt() {
        return txtCpf;
    }

    public void setCpf_txt(JTextField cpf_txt) {
        this.txtCpf = cpf_txt;
    }

    public JButton getEnter_bt() {
        return btnEnter;
    }

    public void setEnter_bt(JButton enter_bt) {
        this.btnEnter = enter_bt;
    }

    public JLabel getSenha_lbl() {
        return lblSenha;
    }

    public void setSenha_lbl(JLabel senha_lbl) {
        this.lblSenha = senha_lbl;
    }

    public JPasswordField getSenha_txt() {
        return txtSenha;
    }

    public void setSenha_txt(JPasswordField senha_txt) {
        this.txtSenha = senha_txt;
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

        pnlAux = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        titulo1 = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnEnter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login_CriptoTrader");
        setMinimumSize(new java.awt.Dimension(350, 450));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlAux.setBackground(new java.awt.Color(200, 200, 200));
        pnlAux.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlAux.setMinimumSize(new java.awt.Dimension(300, 400));
        pnlAux.setPreferredSize(new java.awt.Dimension(300, 400));

        titulo.setBackground(new java.awt.Color(100, 100, 100));
        titulo.setFont(new java.awt.Font("Swis721 BlkCn BT", 3, 26)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 181, 127));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("CriptoTrader");
        titulo.setToolTipText("");

        titulo1.setBackground(new java.awt.Color(100, 100, 100));
        titulo1.setFont(new java.awt.Font("Swis721 BlkCn BT", 3, 26)); // NOI18N
        titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1.setText("CriptoTrader");
        titulo1.setToolTipText("");

        lblCpf.setText(" CPF (Apenas Numeros)");

        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        lblSenha.setText(" Senha ");

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        btnEnter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEnter.setText("ENTRAR");
        btnEnter.setToolTipText("");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAuxLayout = new javax.swing.GroupLayout(pnlAux);
        pnlAux.setLayout(pnlAuxLayout);
        pnlAuxLayout.setHorizontalGroup(
            pnlAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAuxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlAuxLayout.createSequentialGroup()
                .addGroup(pnlAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAuxLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAuxLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(pnlAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAuxLayout.createSequentialGroup()
                                    .addComponent(lblCpf)
                                    .addGap(115, 115, 115)))
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSenha))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(pnlAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlAuxLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(titulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlAuxLayout.setVerticalGroup(
            pnlAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAuxLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(57, 57, 57)
                .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(pnlAuxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlAuxLayout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(299, Short.MAX_VALUE)))
        );

        getContentPane().add(pnlAux, new java.awt.GridBagConstraints());

        setSize(new java.awt.Dimension(736, 519));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        txtSenha.requestFocus();
    }//GEN-LAST:event_txtCpfActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        c.validarLogin(txtCpf.getText(), new String(txtSenha.getPassword()));
    }//GEN-LAST:event_btnEnterActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        btnEnter.doClick();
    }//GEN-LAST:event_txtSenhaActionPerformed

            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel pnlAux;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
