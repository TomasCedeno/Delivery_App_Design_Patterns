package view;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import logic.GUIfactory.*;
import db.DBFacade;
import logic.product.Purchase;
import logic.account.Account;
import logic.account.User;

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
    private String userId = "1234"; //Debería ser pasado en el constructor
    private User user;
    private Account account;
    private GUIFactory factory;
    
    public AccountBuilder(){
        this.factory = new AccountFactory();
        db = new DBFacade();
        user = db.getUser(userId);
        account = (Account) user.getAccount(); 
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
                                        .addComponent(labels[1], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labels[4], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labels[3], javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
                                    .addGroup(jpAccountLayout.createSequentialGroup()
                                        .addComponent(buttons[0], javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(buttons[1], javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(buttons[3], javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(labels[10], javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labels[8], javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)))
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
                                .addGap(125, 125, 125)
                                .addComponent(labels[0]))
                            .addGroup(jpAccountLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttons[4], javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttons[2], javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(23, 23, 23))))
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
                        .addComponent(labels[1])
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labels[5])
                    .addComponent(labels[4])
                    .addComponent(textFields[2], javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labels[3])
                    .addComponent(buttons[2]))
                .addGap(18, 18, 18)
                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addComponent(labels[9])
                        .addGap(15, 15, 15)
                        .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpAccountLayout.createSequentialGroup()
                                .addComponent(scrollPanePurchases, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(jpAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(buttons[0])
                                    .addComponent(buttons[1])
                                    .addComponent(buttons[3]))
                                .addGap(21, 21, 21))
                            .addGroup(jpAccountLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(labels[0])
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPaneDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(55, Short.MAX_VALUE))))
                    .addGroup(jpAccountLayout.createSequentialGroup()
                        .addComponent(buttons[4])
                        .addGap(0, 0, Short.MAX_VALUE))))
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
    
    private void setTblPurchases() {
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
        int selectedRow = tblPurchases.getSelectedRow();
        Purchase purchase = db.getPurchasesByAccount(account.getId()).get(selectedRow);

        editorPaneDetail.setText(purchase.getProductsDetail());
    }
    
}
