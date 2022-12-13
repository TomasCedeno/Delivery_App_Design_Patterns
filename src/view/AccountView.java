package view;

import javax.swing.table.DefaultTableModel;

import db.DBFacade;
import logic.account.Account;
import logic.account.User;
import logic.product.Purchase;

public class AccountView extends javax.swing.JFrame {

    private DBFacade db;
    private String userId = "1234";
    private User user;
    private Account account;
    
    public AccountView() {
        db = new DBFacade();
        user = db.getUser(userId);
        account = (Account) user.getAccount();
        initComponents();
        setTblPurchases();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpAccount = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnCart = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblDetail = new javax.swing.JLabel();
        scrollPanePurchases = new javax.swing.JScrollPane();
        tblPurchases = new javax.swing.JTable();
        lblName = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblBirthDay = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblIdentification = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        lblHistory = new javax.swing.JLabel();
        btnAccount = new javax.swing.JButton();
        scrollPaneDetail = new javax.swing.JScrollPane();
        editorPaneDetail = new javax.swing.JEditorPane();
        lblPoints = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnDecorator = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnHome.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        btnHome.setText("Inicio");

        btnCart.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        btnCart.setText("Carrito");

        btnUpdate.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        btnUpdate.setText("Actualizar Datos");

        lblDetail.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblDetail.setText("Detalle Compra");

        tblPurchases.setRowHeight(32);
        tblPurchases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPurchasesMouseClicked(evt);
            }
        });
        scrollPanePurchases.setViewportView(tblPurchases);

        lblName.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblName.setText("Nombre: ");

        lblTitle.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblTitle.setText("Cuenta");

        lblBirthDay.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblBirthDay.setText("Fecha de Nacimiento: ");

        lblLastName.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblLastName.setText("Apellido: ");

        lblPassword.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblPassword.setText("Contraseña:");

        lblAddress.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblAddress.setText("Dirección: ");

        lblEmail.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblEmail.setText("Email:");

        lblIdentification.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblIdentification.setText("Identificación:");

        lblHistory.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblHistory.setText("Historial Compras");

        btnAccount.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        btnAccount.setText("Cuenta");

        editorPaneDetail.setEditable(false);
        scrollPaneDetail.setViewportView(editorPaneDetail);

        lblPoints.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblPoints.setText("Puntos: ");

        btnDecorator.setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        btnDecorator.setText("Boost (Decorator)");

        javax.swing.GroupLayout jpAccountLayout = new javax.swing.GroupLayout(jpAccount);
        jpAccount.setLayout(jpAccountLayout);
        jpAccountLayout.setHorizontalGroup(
            jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAccountLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(lblHistory)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAccountLayout.createSequentialGroup()
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPanePurchases, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jpAccountLayout.createSequentialGroup()
                                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblBirthDay, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
                                    .addGroup(jpAccountLayout.createSequentialGroup()
                                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(btnCart, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(btnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblPoints, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblIdentification, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAccountLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPaneDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpAccountLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAccountLayout.createSequentialGroup()
                                        .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpAccountLayout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblAddress))
                                        .addGap(32, 32, 32))
                                    .addGroup(jpAccountLayout.createSequentialGroup()
                                        .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)))
                                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                    .addComponent(txtEmail)
                                    .addComponent(txtAddress)))
                            .addGroup(jpAccountLayout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(lblDetail))
                            .addGroup(jpAccountLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDecorator, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(23, 23, 23))))
        );
        jpAccountLayout.setVerticalGroup(
            jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail))
                        .addGap(18, 18, 18)
                        .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddress))
                        .addGap(13, 13, 13))
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addComponent(lblPoints)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblIdentification)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(lblLastName)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBirthDay)
                    .addComponent(btnUpdate))
                .addGap(18, 18, 18)
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addComponent(lblHistory)
                        .addGap(15, 15, 15)
                        .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpAccountLayout.createSequentialGroup()
                                .addComponent(scrollPanePurchases, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnHome)
                                    .addComponent(btnCart)
                                    .addComponent(btnAccount))
                                .addGap(21, 21, 21))
                            .addGroup(jpAccountLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblDetail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPaneDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(55, Short.MAX_VALUE))))
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addComponent(btnDecorator)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPurchasesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPurchasesMouseClicked
        int selectedRow = tblPurchases.getSelectedRow();
        Purchase purchase = db.getPurchasesByAccount(account.getId()).get(selectedRow);

        editorPaneDetail.setText(purchase.getProductsDetail());
    }//GEN-LAST:event_tblPurchasesMouseClicked

    
    public void setTblPurchases() {
        String[] headers = {"Ref. Compra", "Valor Total", "Método de Pago"};
        tblPurchases.removeAll();
        
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        tblPurchases.setModel(tableModel);
                
        db.getPurchasesByAccount(account.getId()).forEach((purchase) -> {
            tableModel.addRow(purchase.toArray());
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnCart;
    private javax.swing.JButton btnDecorator;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JEditorPane editorPaneDetail;
    private javax.swing.JPanel jpAccount;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBirthDay;
    private javax.swing.JLabel lblDetail;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHistory;
    private javax.swing.JLabel lblIdentification;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPoints;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane scrollPaneDetail;
    private javax.swing.JScrollPane scrollPanePurchases;
    private javax.swing.JTable tblPurchases;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
