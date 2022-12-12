
package view;

import java.awt.event.*;
import javax.swing.*;
import logic.GUIfactory.*;
import logic.product.Lists.*;
import logic.product.Product;

public class CartBuilder implements GUIBuilder {
    private JFrame window;
    private JPanel jpCart;
    private JLabel[] labels;
    private JButton[] buttons;
    private GUIFactory factory;
    private ProductList products;
    private Iterator itUp, itDown;
    
    public CartBuilder(){
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
                        .addComponent(labels[0])
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.LEADING, jpHomeLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jpHomeLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpHomeLayout.createSequentialGroup()
                                .addComponent(buttons[3], GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttons[4], GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttons[5], GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpHomeLayout.createSequentialGroup()
                                .addComponent(buttons[0])
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttons[2], GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(buttons[2])
                    .addComponent(buttons[1]))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpHomeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[3])
                    .addComponent(buttons[4])
                    .addComponent(buttons[5]))
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
}
