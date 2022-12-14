
package view;

import java.awt.event.*;
import javax.swing.*;
import logic.GUIfactory.*;
import logic.product.Lists.*;
import logic.product.Product;
import logic.product.Purchase;
import logic.product.commands.*;
import test.Out;

public class CartBuilder implements GUIBuilder {
    private JFrame window;
    private JPanel jpCart;
    private JLabel[] labels;
    private JButton[] buttons;
    private GUIFactory factory;
    private ProductList products;
    private Iterator itUp, itDown;
    private Purchase purchase;
    private ViewMediator mediator;
    private String userId;
    
    public CartBuilder(ViewMediator mediator){
        this.mediator = mediator;
        this.factory = new CartFactory();    
        this.products = new CartProductList();
        itUp = products.createUpIterator();
        itDown = products.createDownIterator();
        itUp.setCurrentPosition(0);
        itDown.setCurrentPosition(0);
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
        
        javax.swing.GroupLayout jpHomeLayout = new javax.swing.GroupLayout(jpCart);
        jpCart.setLayout(jpHomeLayout);
        jpHomeLayout.setHorizontalGroup(
            jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpHomeLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(labels[0]))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpHomeLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpHomeLayout.createSequentialGroup()
                                .addComponent(buttons[4], javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttons[5], javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttons[6], javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpHomeLayout.createSequentialGroup()
                                .addComponent(buttons[0])
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttons[3])
                                .addGap(2, 2, 2)
                                .addComponent(buttons[2])
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttons[1])))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jpHomeLayout.setVerticalGroup(
            jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labels[0])
                .addGap(363, 363, 363)
                .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[0])
                    .addComponent(buttons[3])
                    .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttons[2])
                        .addComponent(buttons[1])))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[4])
                    .addComponent(buttons[5])
                    .addComponent(buttons[6]))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(window.getContentPane());
        window.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        window.pack();
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
    
    boolean band = true;

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    private void btnNextMouseClicked(MouseEvent evt) {   
        // Primero hay que tener un producto en la interfaz
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
        for(int i=0;i<products.getProducts().size();i++){
            products.getProducts().get(i).setBrand(products.getProducts().get(i).getProductView().getCbBrand().getSelectedItem().toString());
            products.getProducts().get(i).setColor(products.getProducts().get(i).getProductView().getCbColor().getSelectedItem().toString()); 
            products.getProducts().get(i).setQuantity(Integer.parseInt(products.getProducts().get(i).getProductView().getCbQuantity().getSelectedItem().toString())); 
        }
        
        purchase = new Purchase(0, 0, "Nequi", 1000);
        
        DataSender ds = new BuyCommand(purchase);
        
        for(int i=0;i<products.getProducts().size();i++){
            ds.sendData(products.getProducts().get(i));
        }
        
        Out.show(purchase.getProductsDetail());
    }
    
    private void btnDelMouseClicked(MouseEvent evt) { 
        products.getProducts().remove(0);
        window.validate();
    }
    
    private void btnHomeActionPerformed(ActionEvent evt) {
        mediator.notify(this, "home", userId);
    }
    
    private void btnCartActionPerformed(ActionEvent evt) {                                        
    } 
    
    private void btnAccountActionPerformed(ActionEvent evt) {                                        
        mediator.notify(this, "account", userId);
    } 
}
