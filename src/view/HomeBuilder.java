
package view;

import java.awt.event.*;
import javax.swing.*;
import logic.GUIfactory.*;
import logic.product.*;
import logic.product.Lists.*;
import logic.product.commands.*;

public class HomeBuilder implements GUIBuilder {
    private JFrame window;
    private JPanel jpHome;
    private JLabel[] labels;
    private JButton[] buttons;
    private JComboBox[] comboBoxes;
    private GUIFactory factory;
    private ProductList products;
    private Cart cart;
    private Purchase purchase;
    private ViewMediator mediator;
    private String userId;
    
    public HomeBuilder(ViewMediator mediator){
        this.mediator = mediator;
        this.factory = new HomeFactory();    
        this.products = new HomeProductList();
        this.cart = new Cart();
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
        comboBoxes = factory.createComboBoxes();
    }

    @Override
    public void createTextFields() { }   
    
    @Override
    public void addEvents() {
        comboBoxes[0].addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED)
                cbSearchBarItemStateChanged(evt);
            }
        });
        
        buttons[0].addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnPreviousMouseClicked(evt);
            }
        });
        
        buttons[1].addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });
        
        buttons[3].addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        
        buttons[2].addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnBuyMouseClicked(evt);
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
        jpHome = new JPanel();  
        
        GroupLayout jpHomeLayout = new GroupLayout(jpHome);
        jpHome.setLayout(jpHomeLayout);
        jpHomeLayout.setHorizontalGroup(
            jpHomeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addGroup(jpHomeLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(GroupLayout.Alignment.LEADING, jpHomeLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jpHomeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(labels[0])
                            .addGroup(jpHomeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(comboBoxes[0], 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(products.getProducts().get(0).getProductView(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(GroupLayout.Alignment.LEADING, jpHomeLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jpHomeLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpHomeLayout.createSequentialGroup()
                                .addComponent(buttons[4], GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttons[5], GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttons[6], GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(jpHomeLayout.createSequentialGroup()
                                .addComponent(buttons[0])
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttons[3])
                                .addGap(2, 2, 2)
                                .addComponent(buttons[2])
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttons[1])))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jpHomeLayout.setVerticalGroup(
            jpHomeLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labels[0])
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxes[0], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(products.getProducts().get(0).getProductView(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jpHomeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[0])
                    .addComponent(buttons[3])
                    .addComponent(buttons[2])
                    .addComponent(buttons[1]))
                .addGap(20,20,20)
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
            .addComponent(jpHome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jpHome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        window.pack();
    }
    
    @Override
    public JFrame getFrame() {
        return this.window;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    private void cbSearchBarItemStateChanged(ItemEvent evt) { 
        int index = comboBoxes[0].getSelectedIndex();
        
        for (int i = 0; i < jpHome.getComponentCount(); i++) {
            if(jpHome.getComponent(i) == products.getProducts().get(0).getProductView() || 
                    jpHome.getComponent(i) == products.getProducts().get(3).getProductView() || 
                    jpHome.getComponent(i) == products.getProducts().get(6).getProductView()){
                jpHome.remove(i);
                jpHome.repaint();
            }
        }
        products.getProducts().get(index).updateView();
        jpHome.add(products.getProducts().get(index).getProductView());
        window.validate();
    } 
    
    private void btnPreviousMouseClicked(MouseEvent evt) {
        Iterator it = products.createDownIterator();
        it.setCurrentPosition(comboBoxes[0].getSelectedIndex());
        if(it.hasMore()) comboBoxes[0].setSelectedItem(it.getNextProduct().getName());
    }
    
    private void btnNextMouseClicked(MouseEvent evt) {   
        Iterator it = products.createUpIterator();
        it.setCurrentPosition(comboBoxes[0].getSelectedIndex());
        if(it.hasMore()) comboBoxes[0].setSelectedItem(it.getNextProduct().getName());
    }
    
    private void btnAddMouseClicked(MouseEvent evt) { 
        Product p = products.getProducts().get(comboBoxes[0].getSelectedIndex());
        p.setBrand(p.getProductView().getCbBrand().getSelectedItem().toString());
        p.setColor(p.getProductView().getCbColor().getSelectedItem().toString()); 
        p.setQuantity(Integer.parseInt(p.getProductView().getCbQuantity().getSelectedItem().toString())); 
        DataSender ds = new AddToCartCommand(cart);
        ds.sendData(p);
    }
    
    private void btnBuyMouseClicked(MouseEvent evt) { 
        Product p = products.getProducts().get(comboBoxes[0].getSelectedIndex());
        p.setBrand(p.getProductView().getCbBrand().getSelectedItem().toString());
        p.setColor(p.getProductView().getCbColor().getSelectedItem().toString()); 
        p.setQuantity(Integer.parseInt(p.getProductView().getCbQuantity().getSelectedItem().toString())); 
        
        purchase = new Purchase(0, 0, "Nequi", 1000);
        
        DataSender ds = new BuyCommand(purchase);
        ds.sendData(p);
    }
    
    private void btnHomeActionPerformed(ActionEvent evt) {   
        mediator.notify(this, "home", userId);
    } 
    
    private void btnCartActionPerformed(ActionEvent evt) {                                        
        mediator.notify(this, "cart", userId);
    } 
    
    private void btnAccountActionPerformed(ActionEvent evt) {                                        
        mediator.notify(this, "account", userId);
    } 
}
