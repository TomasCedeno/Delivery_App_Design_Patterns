
package view;

import Launcher.*;
import db.DBFacade;
import java.awt.event.*;
import javax.swing.*;
import logic.GUIfactory.*;
import logic.account.Account;
import logic.product.Lists.*;
import logic.product.*;
import logic.product.commands.*;
import logic.account.*;

public class CartBuilder implements GUIBuilder {
    private JFrame window;
    private JPanel jpCart;
    private JLabel[] labels;
    private JButton[] buttons;
    private GUIFactory factory;
    private Iterator itUp, itDown;
    private Purchase purchase;
    private ViewMediator mediator;
    private String userId;
    private Cart cart;
    private DBFacade db;
    
    public CartBuilder(ViewMediator mediator){
        this.mediator = mediator;
        this.factory = new CartFactory();
        this.db = new DBFacade();
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
    public void createComboBoxes() { }

    @Override
    public void createTextFields() { }

    @Override
    public void addEvents() {
        buttons[1].addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });
        buttons[0].addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnPreviousMouseClicked(evt);
            }
        });
        
        buttons[2].addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnBuyMouseClicked(evt);
            }
        });
        
        buttons[3].addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnDelMouseClicked(evt);
            }
        });
        
        buttons[4].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        
        buttons[5].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartActionPerformed(evt);
            }
        });
        
        buttons[6].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });
    }

    @Override
    public void createWindow() {
        this.window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jpCart = new JPanel(); 
        
        GroupLayout jpHomeLayout = new GroupLayout(jpCart);
        jpCart.setLayout(jpHomeLayout);
        jpHomeLayout.setHorizontalGroup(
            jpHomeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addGroup(jpHomeLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(GroupLayout.Alignment.LEADING, jpHomeLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(labels[0]))
                    .addGroup(GroupLayout.Alignment.LEADING, jpHomeLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jpHomeLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpHomeLayout.createSequentialGroup()
                                .addComponent(buttons[4], GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttons[5], GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttons[6], GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpHomeLayout.createSequentialGroup()
                                .addComponent(buttons[0])
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttons[3])
                                .addGap(2, 2, 2)
                                .addComponent(buttons[2])
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttons[1])))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jpHomeLayout.setVerticalGroup(
            jpHomeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labels[0])
                .addGap(363, 363, 363)
                .addGroup(jpHomeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[0])
                    .addComponent(buttons[3])
                    .addGroup(jpHomeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttons[2])
                        .addComponent(buttons[1])))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpHomeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[4])
                    .addComponent(buttons[5])
                    .addComponent(buttons[6]))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(window.getContentPane());
        window.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jpCart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jpCart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        window.pack();
        addFirstProduct();
    }

    @Override
    public JFrame getFrame() {
        return this.window;
    }
    
    private void btnPreviousMouseClicked(MouseEvent evt) {
        // Primero hay que tener un producto en la interfaz
        if(itDown.hasMore()){
            Product p = itDown.getNextProduct();
            itUp.setCurrentPosition(itUp.getCurrentPosition()-1);
            jpCart.remove(jpCart.getComponentCount()-1);
            jpCart.repaint();
            p.updateView();
            jpCart.add(p.getProductView());
            window.validate();
        }
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    private void btnNextMouseClicked(MouseEvent evt) {   
        if(itUp.hasMore()){
            Product p = itUp.getNextProduct();
            itDown.setCurrentPosition(itDown.getCurrentPosition()+1);
            jpCart.remove(jpCart.getComponentCount()-1);
            jpCart.repaint();
            p.updateView();
            jpCart.add(p.getProductView());
            window.validate();
        }
    }
    
    private void btnBuyMouseClicked(MouseEvent evt) { 
        Cart cartClone = ((Cart) cart.clone());
        
        for(int i=0;i<cartClone.getProducts().size();i++){
            cartClone.getProducts().get(i).setBrand(cartClone.getProducts().get(i).getProductView().getCbBrand().getSelectedItem().toString());
            cartClone.getProducts().get(i).setColor(cartClone.getProducts().get(i).getProductView().getCbColor().getSelectedItem().toString()); 
            cartClone.getProducts().get(i).setQuantity(Integer.parseInt(cartClone.getProducts().get(i).getProductView().getCbQuantity().getSelectedItem().toString())); 
        }
        
        purchase = new Purchase(0, ((Account)db.getUser(userId).getAccount()).getId(), "", cartClone.getPrice());
        
        AbstractAccount account = db.getAccountWithBenefits(userId);
        if(account.getPaymentMethod() == null) account.setPaymentMethod(setNewPaymentMethod());
        
        DataSender ds = new BuyCommand(purchase, account);
                
        Out.show(ds.sendData(cartClone, userId));
    }
    
    private void btnDelMouseClicked(MouseEvent evt) { 
        cart.getProducts().remove(itUp.getCurrentPosition());
        window.repaint();
        if(itUp.hasMore()){ btnNextMouseClicked(null); }
        else { btnPreviousMouseClicked(null); }
    }
    
    private void btnHomeActionPerformed(ActionEvent evt) {
        mediator.notify(this, "home", cart, userId);
    }
    
    private void btnCartActionPerformed(ActionEvent evt) {   
        mediator.notify(this, "cart", cart, userId);
    } 
    
    private void btnAccountActionPerformed(ActionEvent evt) {                                        
        mediator.notify(this, "account", cart, userId);
    } 
    
    public void setCart(Cart cart){
        this.cart = cart;
        this.itUp = cart.createUpIterator();
        this.itUp.setCurrentPosition(0);
        this.itDown = cart.createDownIterator();
    }
    
    public void addFirstProduct(){
        if(!cart.getProducts().isEmpty()){
            Product p = cart.getElement(0);
            p.updateView();
            jpCart.add(p.getProductView());
            window.validate();   
        }
    }
    
    private PaymentMethod setNewPaymentMethod(){
        PaymentMethod newPaymentMethod = null;
        String option = In.read("¿Qué método de pago desea usar?\n1) Tarjeta de crédito\n2) Nequi\n3) Paypal");
        
        switch(option){
            case "1": 
                newPaymentMethod = new CreditCard(
                        In.read("Número de cuenta: "), 
                        In.read("Contraseña: "), 
                        In.read("CCV: "), 
                        In.read("Fecha de expiración: "));
                break;
            case "2":
                newPaymentMethod = new Nequi(
                        In.read("Número de cuenta: "), 
                        In.read("Contraseña: "));
                break;
            case "3":
                newPaymentMethod = new Paypal(
                        In.read("E-mail de la cuenta: "), 
                        In.read("Contraseña: "));
                break;
            default: Out.show(option + " no está entre las opciones."); break;
        }
        
        return newPaymentMethod;
    }
}
