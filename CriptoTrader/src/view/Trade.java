package view;
import controller.ControleTrade;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Investidor;

public class Trade extends javax.swing.JFrame {


    public Trade() {
        initComponents();

    }

    private ControleTrade c;

    // ================== Getters ==================

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        pnlAreaCotacoes = new javax.swing.JPanel();
        lblCotacaoAtual = new javax.swing.JLabel();
        lblBtc = new javax.swing.JLabel();
        lblValorBtc = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblEth = new javax.swing.JLabel();
        lblValorEth = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblXrp = new javax.swing.JLabel();
        lblValorXrp = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        pnlAreaTrade = new javax.swing.JPanel();
        lblQuantidade = new javax.swing.JLabel();
        ftxtValorDeposito = new javax.swing.JFormattedTextField();
        lblSeleciona = new javax.swing.JLabel();
        pnlSubtotal = new javax.swing.JPanel();
        lblSubtotal = new javax.swing.JLabel();
        lblTaxa = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblSubtotalValor = new javax.swing.JLabel();
        lblTaxaValor = new javax.swing.JLabel();
        lblTotalValor = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btnComprar = new javax.swing.JToggleButton();
        btnVender = new javax.swing.JToggleButton();
        btnExecutarOperacao = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trade_Cripto");
        setMinimumSize(new java.awt.Dimension(1001, 563));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlPrincipal.setBackground(new java.awt.Color(245, 247, 250));
        pnlPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        pnlPrincipal.setMaximumSize(new java.awt.Dimension(1250, 700));
        pnlPrincipal.setMinimumSize(new java.awt.Dimension(1001, 563));
        pnlPrincipal.setName(""); // NOI18N
        pnlPrincipal.setPreferredSize(new java.awt.Dimension(1001, 563));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("Trade de Criptomoedas");

        btnVoltar.setBackground(new java.awt.Color(204, 204, 204));
        btnVoltar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVoltar.setForeground(java.awt.Color.darkGray);
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        pnlAreaCotacoes.setBackground(new java.awt.Color(19, 18, 58));

        lblCotacaoAtual.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCotacaoAtual.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblCotacaoAtual.setText("Cotações Atuais");

        lblBtc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBtc.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblBtc.setText("Bitcoin (BTC)");

        lblValorBtc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblValorBtc.setForeground(new java.awt.Color(255, 255, 0));
        lblValorBtc.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblValorBtc.setText("0.0");

        lblEth.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEth.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblEth.setText("Ethereum (ETH)");

        lblValorEth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblValorEth.setForeground(new java.awt.Color(255, 255, 0));
        lblValorEth.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblValorEth.setText("0.0");

        lblXrp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblXrp.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblXrp.setText("Ripple (XRP)");

        lblValorXrp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblValorXrp.setForeground(new java.awt.Color(255, 255, 0));
        lblValorXrp.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblValorXrp.setText("0.0");

        javax.swing.GroupLayout pnlAreaCotacoesLayout = new javax.swing.GroupLayout(pnlAreaCotacoes);
        pnlAreaCotacoes.setLayout(pnlAreaCotacoesLayout);
        pnlAreaCotacoesLayout.setHorizontalGroup(
            pnlAreaCotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAreaCotacoesLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(pnlAreaCotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAreaCotacoesLayout.createSequentialGroup()
                        .addComponent(lblCotacaoAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAreaCotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlAreaCotacoesLayout.createSequentialGroup()
                            .addComponent(lblXrp)
                            .addGap(73, 73, 73)
                            .addComponent(lblValorXrp, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlAreaCotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAreaCotacoesLayout.createSequentialGroup()
                                .addComponent(lblBtc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblValorBtc, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAreaCotacoesLayout.createSequentialGroup()
                                .addComponent(lblEth)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(lblValorEth, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(40, 40, 40))
        );
        pnlAreaCotacoesLayout.setVerticalGroup(
            pnlAreaCotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAreaCotacoesLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lblCotacaoAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(52, 52, 52)
                .addGroup(pnlAreaCotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblValorBtc)
                    .addComponent(lblBtc, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pnlAreaCotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblValorEth)
                    .addComponent(lblEth, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAreaCotacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblValorXrp)
                    .addComponent(lblXrp, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pnlAreaTrade.setBackground(new java.awt.Color(255, 255, 255));
        pnlAreaTrade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQuantidade.setText("Quantidade");

        ftxtValorDeposito.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        ftxtValorDeposito.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        ftxtValorDeposito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ftxtValorDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtValorDepositoActionPerformed(evt);
            }
        });

        lblSeleciona.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSeleciona.setText("Selecione a Criptomoeda:");

        pnlSubtotal.setBackground(new java.awt.Color(237, 237, 237));

        lblSubtotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSubtotal.setText("Subtotal:");

        lblTaxa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTaxa.setForeground(new java.awt.Color(223, 9, 9));
        lblTaxa.setText("Taxa (X%):");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTotal.setText("Total:");

        lblSubtotalValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSubtotalValor.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblSubtotalValor.setText("R$");

        lblTaxaValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTaxaValor.setForeground(new java.awt.Color(223, 9, 9));
        lblTaxaValor.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblTaxaValor.setText("R$");

        lblTotalValor.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTotalValor.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblTotalValor.setText("R$");

        javax.swing.GroupLayout pnlSubtotalLayout = new javax.swing.GroupLayout(pnlSubtotal);
        pnlSubtotal.setLayout(pnlSubtotalLayout);
        pnlSubtotalLayout.setHorizontalGroup(
            pnlSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubtotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addGroup(pnlSubtotalLayout.createSequentialGroup()
                        .addGroup(pnlSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTaxaValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSubtotalValor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlSubtotalLayout.setVerticalGroup(
            pnlSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubtotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSubtotalLayout.createSequentialGroup()
                        .addComponent(lblSubtotalValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTaxaValor))
                    .addGroup(pnlSubtotalLayout.createSequentialGroup()
                        .addComponent(lblSubtotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTaxa)))
                .addGap(3, 3, 3)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(pnlSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalValor)
                    .addComponent(lblTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroup1.add(btnComprar);
        btnComprar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnComprar.setForeground(new java.awt.Color(42, 177, 57));
        btnComprar.setText("COMPRAR");

        buttonGroup1.add(btnVender);
        btnVender.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnVender.setForeground(new java.awt.Color(200, 28, 28));
        btnVender.setText("VENDER");

        btnExecutarOperacao.setBackground(new java.awt.Color(51, 102, 255));
        btnExecutarOperacao.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnExecutarOperacao.setText("Executar Operação");
        btnExecutarOperacao.setActionCommand("Executar Operação");
        btnExecutarOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecutarOperacaoActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BTC", "ETH", "XRP" }));

        javax.swing.GroupLayout pnlAreaTradeLayout = new javax.swing.GroupLayout(pnlAreaTrade);
        pnlAreaTrade.setLayout(pnlAreaTradeLayout);
        pnlAreaTradeLayout.setHorizontalGroup(
            pnlAreaTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAreaTradeLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pnlAreaTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSeleciona, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtValorDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(pnlSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAreaTradeLayout.createSequentialGroup()
                        .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnExecutarOperacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        pnlAreaTradeLayout.setVerticalGroup(
            pnlAreaTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAreaTradeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAreaTradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVender, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lblSeleciona, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lblQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ftxtValorDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(pnlSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExecutarOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(pnlAreaCotacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlAreaTrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlAreaCotacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlAreaTrade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        getContentPane().add(pnlPrincipal, new java.awt.GridBagConstraints());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void ftxtValorDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtValorDepositoActionPerformed
        btnExecutarOperacao.requestFocus();
    }//GEN-LAST:event_ftxtValorDepositoActionPerformed

    private void btnExecutarOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecutarOperacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExecutarOperacaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnComprar;
    private javax.swing.JButton btnExecutarOperacao;
    private javax.swing.JToggleButton btnVender;
    private javax.swing.JButton btnVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField ftxtValorDeposito;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblBtc;
    private javax.swing.JLabel lblCotacaoAtual;
    private javax.swing.JLabel lblEth;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblSeleciona;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblSubtotalValor;
    private javax.swing.JLabel lblTaxa;
    private javax.swing.JLabel lblTaxaValor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalValor;
    private javax.swing.JLabel lblValorBtc;
    private javax.swing.JLabel lblValorEth;
    private javax.swing.JLabel lblValorXrp;
    private javax.swing.JLabel lblXrp;
    private javax.swing.JPanel pnlAreaCotacoes;
    private javax.swing.JPanel pnlAreaTrade;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlSubtotal;
    // End of variables declaration//GEN-END:variables

}
