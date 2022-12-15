package view;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import logic.GUIfactory.*;
import db.DBFacade;
import logic.product.Purchase;
import logic.account.Account;
import logic.account.User;
import logic.product.Cart;
import Launcher.Out;

public class AccountBuilder implements GUIBuilder {
    
    private JFrame window;
    private JPanel jpAccount;
    private JLabel[] labels;
    private JButton[] buttons;
    private JTextField[] textFields;
    private JScrollPane scrollPanePurchases;
    private JTable tblPurchases;
    private JScrollPane scrollPaneDetail;
    private JEditorPane editorPaneDetail;
    private DBFacade db;
    private String userId;
    private GUIFactory factory;
    private ViewMediator mediator;
    private Cart cart;
    
    public AccountBuilder(ViewMediator mediator){
        this.mediator = mediator;
        this.factory = new AccountFactory();
        db = new DBFacade(); 
    }
    
    @Override
    public void createLabels() {
        labels = factory.createLabels();
    }

    @Override
    public void createButtons() {
        buttons = factory.createButtons();
    }

    @Override
    public void createComboBoxes() {
        scrollPanePurchases = new JScrollPane();
        tblPurchases = new JTable();
        scrollPaneDetail = new JScrollPane();
        editorPaneDetail = new JEditorPane();
        
        tblPurchases.setRowHeight(32);
        scrollPanePurchases.setViewportView(tblPurchases);
        
        editorPaneDetail.setEditable(false);
        scrollPaneDetail.setViewportView(editorPaneDetail);
    }

    @Override
    public void createTextFields() {
        textFields = factory.createTextFields();
    }

    @Override
    public void addEvents() {
        tblPurchases.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblPurchasesMouseClicked(evt);
            }
        });
        
        buttons[0].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        
        buttons[1].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartActionPerformed(evt);
            }
        });
        
        buttons[3].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });
        
        buttons[2].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        
        buttons[4].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiscountActionPerformed(evt);
            }
        });
        
        buttons[5].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFreeDeliveryActionPerformed(evt);
            }
        });
        
       buttons[6].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtraPointsActionPerformed(evt);
            }
        });
    }

    @Override
    public void createWindow() {
        this.window = new JFrame();
        jpAccount = new JPanel();
        
        window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        javax.swing.GroupLayout jpAccountLayout = new javax.swing.GroupLayout(jpAccount);
        jpAccount.setLayout(jpAccountLayout);
        jpAccountLayout.setHorizontalGroup(
            jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAccountLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(labels[9])
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAccountLayout.createSequentialGroup()
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labels[2], javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPanePurchases, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jpAccountLayout.createSequentialGroup()
                                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labels[2], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labels[4], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labels[3], javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
                                    .addGroup(jpAccountLayout.createSequentialGroup()
                                        .addComponent( buttons[0], javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent( buttons[1], javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent( buttons[3], javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(labels[10], javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labels[8], javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpAccountLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAccountLayout.createSequentialGroup()
                                        .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpAccountLayout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(labels[7], javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(labels[6]))
                                        .addGap(32, 32, 32))
                                    .addGroup(jpAccountLayout.createSequentialGroup()
                                        .addComponent(labels[5], javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)))
                                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textFields[2], javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                    .addComponent(textFields[0])
                                    .addComponent(textFields[1])))
                            .addGroup(jpAccountLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(buttons[2], javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpAccountLayout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(labels[11])))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAccountLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(scrollPaneDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAccountLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(buttons[4], javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttons[6], javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttons[5], javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAccountLayout.createSequentialGroup()
                    .addContainerGap(567, Short.MAX_VALUE)
                    .addComponent(labels[0])
                    .addGap(124, 124, 124)))
        );
        jpAccountLayout.setVerticalGroup(
            jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labels[2], javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textFields[0], javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labels[7]))
                        .addGap(18, 18, 18)
                        .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFields[1], javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labels[6]))
                        .addGap(13, 13, 13))
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addComponent(labels[10])
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labels[8])
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labels[2])
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labels[5])
                    .addComponent(labels[4])
                    .addComponent(textFields[2], javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labels[3])
                    .addComponent(buttons[2]))
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labels[9])
                        .addGap(15, 15, 15)
                        .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPanePurchases, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addGroup(jpAccountLayout.createSequentialGroup()
                                .addComponent(scrollPaneDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent( buttons[0])
                            .addComponent( buttons[1])
                            .addComponent( buttons[3]))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAccountLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttons[4])
                            .addComponent(buttons[5])
                            .addComponent(buttons[6]))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAccountLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labels[11])
                .addGap(44, 44, 44))
            .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpAccountLayout.createSequentialGroup()
                    .addGap(258, 258, 258)
                    .addComponent(labels[0])
                    .addContainerGap(261, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(window.getContentPane());
        window.getContentPane().setLayout(layout);
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

        window.pack();
        
        setUserData();
        setTblPurchases();
    }

    @Override
    public JFrame getFrame() {
        return this.window;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    private void setTblPurchases() {
        Account account = (Account) db.getUser(userId).getAccount();
        String[] headers = {"Ref. Compra", "Valor Total", "Método de Pago"};
        tblPurchases.removeAll();
        
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        tblPurchases.setModel(tableModel);
                
        db.getPurchasesByAccount(account.getId()).forEach((purchase) -> {
            tableModel.addRow(purchase.toArray());
        });
    }
    
    private void setUserData() {
        User user = db.getUser(userId);
        Account account = (Account) user.getAccount();
        labels[10].setText("Puntos: " + account.getPoints());
        labels[8].setText("Identificación: " + user.getIdentification());
        labels[1].setText("Nombre: " + user.getName());
        labels[4].setText("Apellido: " + user.getLastName());
        labels[3].setText("Fecha de Nacimiento: " + user.getBirthDay());
        textFields[0].setText(user.getEmail());
        textFields[1].setText(user.getAddress());
        textFields[2].setText(user.getPassword());
    }
    
    private void tblPurchasesMouseClicked(java.awt.event.MouseEvent evt) {  
        Account account = (Account) db.getUser(userId).getAccount();
        int selectedRow = tblPurchases.getSelectedRow();
        Purchase purchase = db.getPurchasesByAccount(account.getId()).get(selectedRow);

        editorPaneDetail.setText(purchase.getProductsDetail());
    }
    
    private void btnHomeActionPerformed(ActionEvent evt) {
        mediator.notify(this, "home", cart, userId);
    }
    
    private void btnCartActionPerformed(ActionEvent evt) {
        mediator.notify(this, "cart", cart, userId);
    } 
    
    private void btnAccountActionPerformed(ActionEvent evt) { 
        mediator.notify(this, "account", cart,  userId);
    } 
    
    private void btnUpdateActionPerformed(ActionEvent evt) {                                          
        User user = db.getUser(userId);
        user.setAddress(textFields[1].getText());
        user.setPassword(textFields[2].getText());
        db.updateUser(user);
        mediator.notify(this, "account", cart, userId);
    } 
    
    private void btnDiscountActionPerformed(ActionEvent evt) {  
        Account account = (Account) db.getUser(userId).getAccount();
        account.setDiscount(true);
        db.updateAccount(account);
        Out.show("Cuenta Mejorada, tu cuenta tiene: \n" + account.getDetail());
    }                                           

    private void btnExtraPointsActionPerformed(ActionEvent evt) {                                               
        Account account = (Account) db.getUser(userId).getAccount();
        account.setExtraPoints(true);
        db.updateAccount(account);
        Out.show("Cuenta Mejorada, tu cuenta tiene: \n" + account.getDetail());
    }                                              

    private void btnFreeDeliveryActionPerformed(ActionEvent evt) {                                                
        Account account = (Account) db.getUser(userId).getAccount();
        account.setFreeDelivery(true);
        db.updateAccount(account);
        Out.show("Cuenta Mejorada, tu cuenta tiene: \n" + account.getDetail());
    }  
    
    public void setCart(Cart cart){
        this.cart = cart;
    }
}
