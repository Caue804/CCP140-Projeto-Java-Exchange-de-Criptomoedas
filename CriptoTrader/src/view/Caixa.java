package view;
import controller.ConfirmaSenha;
import controller.ControleCaixa;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import model.Investidor;

public class Caixa extends javax.swing.JFrame {


    public Caixa(Investidor investidorLogado, Dashboard dashboard) {
        initComponents();
        c = new ControleCaixa(this, investidorLogado, dashboard);
    }

    private ControleCaixa c;

    // ================== Getters ==================

    public ControleCaixa getC() {
        return c;
    }

    public JButton getBtnDepositar() {
        return btnDepositar;
    }

    public JButton getBtnSacar() {
        return btnSacar;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }

    public JFormattedTextField getFtxtValorDeposito() {
        return ftxtValorDeposito;
    }

    public JFormattedTextField getFtxtValorSaque() {
        return ftxtValorSaque;
    }

    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public JLabel getLblSaldoDeposito() {
        return lblSaldoDeposito;
    }

    public JLabel getLblSaldoSaque() {
        return lblSaldoSaque;
    }

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public JLabel getLblValorDeposito() {
        return lblValorDeposito;
    }

    public JLabel getLblValorSaldoDeposito() {
        return lblValorSaldoDeposito;
    }

    public JLabel getLblValorSaldoSaque() {
        return lblValorSaldoSaque;
    }

    public JLabel getLblValorSaque() {
        return lblValorSaque;
    }

    public JPanel getPnlDepositar() {
        return pnlDepositar;
    }

    public JPanel getPnlPrincipal() {
        return pnlPrincipal;
    }

    public JPanel getPnlSacar() {
        return pnlSacar;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlDepositar = new javax.swing.JPanel();
        lblSaldoDeposito = new javax.swing.JLabel();
        lblValorSaldoDeposito = new javax.swing.JLabel();
        btnDepositar = new javax.swing.JButton();
        lblValorDeposito = new javax.swing.JLabel();
        ftxtValorDeposito = new javax.swing.JFormattedTextField();
        pnlSacar = new javax.swing.JPanel();
        lblSaldoSaque = new javax.swing.JLabel();
        lblValorSaldoSaque = new javax.swing.JLabel();
        btnSacar = new javax.swing.JButton();
        lblValorSaque = new javax.swing.JLabel();
        ftxtValorSaque = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caixa_(Sacar/Depositar)");
        setMinimumSize(new java.awt.Dimension(1001, 563));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlPrincipal.setBackground(new java.awt.Color(245, 247, 250));
        pnlPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnlPrincipal.setMaximumSize(new java.awt.Dimension(1250, 700));
        pnlPrincipal.setMinimumSize(new java.awt.Dimension(1001, 563));
        pnlPrincipal.setName(""); // NOI18N
        pnlPrincipal.setPreferredSize(new java.awt.Dimension(1001, 563));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("Caixa Reais (R$)");

        btnVoltar.setBackground(new java.awt.Color(204, 204, 204));
        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVoltar.setForeground(java.awt.Color.darkGray);
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        lblSaldoDeposito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSaldoDeposito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaldoDeposito.setText("Saldo atual em Reais:");
        lblSaldoDeposito.setToolTipText("");

        lblValorSaldoDeposito.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblValorSaldoDeposito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValorSaldoDeposito.setText("R$");

        btnDepositar.setBackground(new java.awt.Color(102, 255, 102));
        btnDepositar.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnDepositar.setText("Confirmar Depósito");
        btnDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarActionPerformed(evt);
            }
        });

        lblValorDeposito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblValorDeposito.setText("Valor (R$)");

        ftxtValorDeposito.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        ftxtValorDeposito.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        ftxtValorDeposito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ftxtValorDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtValorDepositoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDepositarLayout = new javax.swing.GroupLayout(pnlDepositar);
        pnlDepositar.setLayout(pnlDepositarLayout);
        pnlDepositarLayout.setHorizontalGroup(
            pnlDepositarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDepositarLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(pnlDepositarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, pnlDepositarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(btnDepositar, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                        .addComponent(lblSaldoDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftxtValorDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDepositarLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblValorDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(135, 135, 135))
            .addGroup(pnlDepositarLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lblValorSaldoDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDepositarLayout.setVerticalGroup(
            pnlDepositarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDepositarLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblSaldoDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValorSaldoDeposito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblValorDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ftxtValorDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        jTabbedPane1.addTab("             Depositar             ", pnlDepositar);

        lblSaldoSaque.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSaldoSaque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaldoSaque.setText("Saldo atual em Reais:");
        lblSaldoSaque.setToolTipText("");

        lblValorSaldoSaque.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblValorSaldoSaque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValorSaldoSaque.setText("R$");

        btnSacar.setBackground(new java.awt.Color(102, 255, 102));
        btnSacar.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnSacar.setText("Confirmar Saque");
        btnSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacarActionPerformed(evt);
            }
        });

        lblValorSaque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblValorSaque.setText("Valor (R$)");

        ftxtValorSaque.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        ftxtValorSaque.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        ftxtValorSaque.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ftxtValorSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtValorSaqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSacarLayout = new javax.swing.GroupLayout(pnlSacar);
        pnlSacar.setLayout(pnlSacarLayout);
        pnlSacarLayout.setHorizontalGroup(
            pnlSacarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSacarLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(pnlSacarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, pnlSacarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(btnSacar, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                        .addComponent(lblSaldoSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftxtValorSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSacarLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblValorSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(135, 135, 135))
            .addGroup(pnlSacarLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblValorSaldoSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSacarLayout.setVerticalGroup(
            pnlSacarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSacarLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblSaldoSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValorSaldoSaque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblValorSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ftxtValorSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        jTabbedPane1.addTab("                 Sacar                  ", pnlSacar);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(408, 408, 408)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnlPrincipal, new java.awt.GridBagConstraints());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacarActionPerformed
        if (ConfirmaSenha.confirmar(this, c.getInvestidorLogado())) { //chama o metodo de confirmar, nessa tela, com esse invest
        c.sacar();
        }
    }//GEN-LAST:event_btnSacarActionPerformed

    private void ftxtValorSaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtValorSaqueActionPerformed
        btnSacar.requestFocus();
    }//GEN-LAST:event_ftxtValorSaqueActionPerformed

    private void btnDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarActionPerformed
        if (ConfirmaSenha.confirmar(this, c.getInvestidorLogado())) { //chama o metodo de confirmar, nessa tela, com esse invest
        c.depositar();
        }
    }//GEN-LAST:event_btnDepositarActionPerformed

    private void ftxtValorDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtValorDepositoActionPerformed
        btnDepositar.requestFocus();
    }//GEN-LAST:event_ftxtValorDepositoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDepositar;
    private javax.swing.JButton btnSacar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JFormattedTextField ftxtValorDeposito;
    private javax.swing.JFormattedTextField ftxtValorSaque;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblSaldoDeposito;
    private javax.swing.JLabel lblSaldoSaque;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorDeposito;
    private javax.swing.JLabel lblValorSaldoDeposito;
    private javax.swing.JLabel lblValorSaldoSaque;
    private javax.swing.JLabel lblValorSaque;
    private javax.swing.JPanel pnlDepositar;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlSacar;
    // End of variables declaration//GEN-END:variables

}
