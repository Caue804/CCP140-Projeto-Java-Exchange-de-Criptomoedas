package view;
import controller.ConfirmaSenha;
import controller.ControleDashboard;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Investidor;

public class Dashboard extends javax.swing.JFrame {


    public Dashboard(String cpf) {
        initComponents();
        c = new ControleDashboard(this, cpf);
    }

    private ControleDashboard c;

    // ================== Getters ==================

    public JButton getBtnAttCotacao() {
        return btnAttCotacao;
    }

    public JButton getBtnCaixa() {
        return btnCaixa;
    }

    public JButton getBtnExtrato() {
        return btnExtrato;
    }

    public JButton getBtnSair() {
        return btnSair;
    }

    public JButton getBtnTrade() {
        return btnTrade;
    }

    public JLabel getLblCpf() {
        return lblCpf;
    }

    public JLabel getLblNome() {
        return lblNome;
    }

    public JLabel getLblSaldoBtc() {
        return lblSaldoBtc;
    }

    public JLabel getLblSaldoEth() {
        return lblSaldoEth;
    }

    public JLabel getLblSaldoReais() {
        return lblSaldoReais;
    }

    public JLabel getLblSaldoXrp() {
        return lblSaldoXrp;
    }

    public JLabel getLblTituloSaldoBit() {
        return lblTituloSaldoBit;
    }

    public JLabel getLblTituloSaldoEth() {
        return lblTituloSaldoEth;
    }

    public JLabel getLblTituloSaldoReais() {
        return lblTituloSaldoReais;
    }

    public JLabel getLblTituloSaldoXrp() {
        return lblTituloSaldoXrp;
    }

    public JPanel getPnlBit() {
        return pnlBit;
    }

    public JPanel getPnlEth() {
        return pnlEth;
    }

    public JPanel getPnlPrincipal() {
        return pnlPrincipal;
    }

    public JPanel getPnlReais() {
        return pnlReais;
    }

    public JPanel getPnlXrp() {
        return pnlXrp;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        lblCpf = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        pnlReais = new javax.swing.JPanel();
        lblTituloSaldoReais = new javax.swing.JLabel();
        lblSaldoReais = new javax.swing.JLabel();
        pnlBit = new javax.swing.JPanel();
        lblTituloSaldoBit = new javax.swing.JLabel();
        lblSaldoBtc = new javax.swing.JLabel();
        pnlEth = new javax.swing.JPanel();
        lblTituloSaldoEth = new javax.swing.JLabel();
        lblSaldoEth = new javax.swing.JLabel();
        pnlXrp = new javax.swing.JPanel();
        lblTituloSaldoXrp = new javax.swing.JLabel();
        lblSaldoXrp = new javax.swing.JLabel();
        btnCaixa = new javax.swing.JButton();
        btnTrade = new javax.swing.JButton();
        btnExtrato = new javax.swing.JButton();
        btnAttCotacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard_Investidor");
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1001, 563));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlPrincipal.setBackground(new java.awt.Color(245, 247, 250));
        pnlPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnlPrincipal.setMaximumSize(new java.awt.Dimension(1250, 700));
        pnlPrincipal.setMinimumSize(new java.awt.Dimension(1001, 563));
        pnlPrincipal.setName(""); // NOI18N
        pnlPrincipal.setPreferredSize(new java.awt.Dimension(1001, 563));

        lblCpf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCpf.setText("CPF:");

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNome.setText("Nome");

        btnSair.setBackground(new java.awt.Color(204, 204, 204));
        btnSair.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSair.setForeground(java.awt.Color.red);
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        pnlReais.setBackground(new java.awt.Color(102, 153, 255));
        pnlReais.setPreferredSize(new java.awt.Dimension(200, 130));

        lblTituloSaldoReais.setBackground(new java.awt.Color(204, 204, 204));
        lblTituloSaldoReais.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTituloSaldoReais.setText("Saldo em Reais");

        lblSaldoReais.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lblSaldoReais.setText("R$");

        javax.swing.GroupLayout pnlReaisLayout = new javax.swing.GroupLayout(pnlReais);
        pnlReais.setLayout(pnlReaisLayout);
        pnlReaisLayout.setHorizontalGroup(
            pnlReaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReaisLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlReaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReaisLayout.createSequentialGroup()
                        .addComponent(lblTituloSaldoReais, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblSaldoReais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlReaisLayout.setVerticalGroup(
            pnlReaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReaisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloSaldoReais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSaldoReais, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pnlBit.setBackground(new java.awt.Color(204, 204, 204));
        pnlBit.setPreferredSize(new java.awt.Dimension(200, 130));

        lblTituloSaldoBit.setBackground(new java.awt.Color(204, 204, 204));
        lblTituloSaldoBit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTituloSaldoBit.setText("Bitcoin (BTC)");

        lblSaldoBtc.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lblSaldoBtc.setText("0.");

        javax.swing.GroupLayout pnlBitLayout = new javax.swing.GroupLayout(pnlBit);
        pnlBit.setLayout(pnlBitLayout);
        pnlBitLayout.setHorizontalGroup(
            pnlBitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBitLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlBitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBitLayout.createSequentialGroup()
                        .addComponent(lblTituloSaldoBit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblSaldoBtc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlBitLayout.setVerticalGroup(
            pnlBitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloSaldoBit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSaldoBtc, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pnlEth.setBackground(new java.awt.Color(204, 204, 204));
        pnlEth.setPreferredSize(new java.awt.Dimension(200, 130));

        lblTituloSaldoEth.setBackground(new java.awt.Color(204, 204, 204));
        lblTituloSaldoEth.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTituloSaldoEth.setText("Ethereum (ETH)");

        lblSaldoEth.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lblSaldoEth.setText("0.");

        javax.swing.GroupLayout pnlEthLayout = new javax.swing.GroupLayout(pnlEth);
        pnlEth.setLayout(pnlEthLayout);
        pnlEthLayout.setHorizontalGroup(
            pnlEthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEthLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlEthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEthLayout.createSequentialGroup()
                        .addComponent(lblTituloSaldoEth, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addComponent(lblSaldoEth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlEthLayout.setVerticalGroup(
            pnlEthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloSaldoEth, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSaldoEth, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pnlXrp.setBackground(new java.awt.Color(204, 204, 204));
        pnlXrp.setPreferredSize(new java.awt.Dimension(200, 130));

        lblTituloSaldoXrp.setBackground(new java.awt.Color(204, 204, 204));
        lblTituloSaldoXrp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTituloSaldoXrp.setText("Ripple (XRP)");

        lblSaldoXrp.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lblSaldoXrp.setText("0.");

        javax.swing.GroupLayout pnlXrpLayout = new javax.swing.GroupLayout(pnlXrp);
        pnlXrp.setLayout(pnlXrpLayout);
        pnlXrpLayout.setHorizontalGroup(
            pnlXrpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlXrpLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlXrpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlXrpLayout.createSequentialGroup()
                        .addComponent(lblTituloSaldoXrp, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblSaldoXrp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlXrpLayout.setVerticalGroup(
            pnlXrpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlXrpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloSaldoXrp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSaldoXrp, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        btnCaixa.setBackground(new java.awt.Color(255, 255, 255));
        btnCaixa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCaixa.setText("Caixa (R$)");
        btnCaixa.setPreferredSize(new java.awt.Dimension(200, 130));
        btnCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaixaActionPerformed(evt);
            }
        });

        btnTrade.setBackground(new java.awt.Color(255, 255, 255));
        btnTrade.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnTrade.setText("Trade Cripto");
        btnTrade.setPreferredSize(new java.awt.Dimension(200, 130));
        btnTrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTradeActionPerformed(evt);
            }
        });

        btnExtrato.setBackground(new java.awt.Color(255, 255, 255));
        btnExtrato.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnExtrato.setText("Ver Extrato");
        btnExtrato.setPreferredSize(new java.awt.Dimension(200, 130));
        btnExtrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtratoActionPerformed(evt);
            }
        });

        btnAttCotacao.setBackground(new java.awt.Color(255, 255, 255));
        btnAttCotacao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAttCotacao.setText("<html><center>Atualizar<br>Cotações</center></html>");
        btnAttCotacao.setMaximumSize(new java.awt.Dimension(200, 130));
        btnAttCotacao.setMinimumSize(new java.awt.Dimension(200, 130));
        btnAttCotacao.setPreferredSize(new java.awt.Dimension(200, 130));
        btnAttCotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttCotacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlReais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlBit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlEth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExtrato, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAttCotacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlXrp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pnlReais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlEth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlXrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnTrade, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExtrato, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAttCotacao, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        getContentPane().add(pnlPrincipal, new java.awt.GridBagConstraints());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTradeActionPerformed
        Trade telaTrade = new Trade();
        telaTrade.setVisible(true); 
    }//GEN-LAST:event_btnTradeActionPerformed

    private void btnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaixaActionPerformed
        Caixa telaCaixa = new Caixa();
        telaCaixa.setVisible(true); 
    }//GEN-LAST:event_btnCaixaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
        Login telaLogin = new Login();
        telaLogin.setVisible(true);        
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnExtratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtratoActionPerformed
        
        if (ConfirmaSenha.confirmar(this, c.getInvestidorLogado())) { //chama o metodo de confirmar, nessa tela, com esse invest
            Extrato telaExtrato = new Extrato(); //se passar, instancia e abre a tela
            telaExtrato.setVisible(true);
        }

    }//GEN-LAST:event_btnExtratoActionPerformed

    private void btnAttCotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttCotacaoActionPerformed
        c.atualizarCotacoes();
    }//GEN-LAST:event_btnAttCotacaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAttCotacao;
    private javax.swing.JButton btnCaixa;
    private javax.swing.JButton btnExtrato;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTrade;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSaldoBtc;
    private javax.swing.JLabel lblSaldoEth;
    private javax.swing.JLabel lblSaldoReais;
    private javax.swing.JLabel lblSaldoXrp;
    private javax.swing.JLabel lblTituloSaldoBit;
    private javax.swing.JLabel lblTituloSaldoEth;
    private javax.swing.JLabel lblTituloSaldoReais;
    private javax.swing.JLabel lblTituloSaldoXrp;
    private javax.swing.JPanel pnlBit;
    private javax.swing.JPanel pnlEth;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlReais;
    private javax.swing.JPanel pnlXrp;
    // End of variables declaration//GEN-END:variables

}
