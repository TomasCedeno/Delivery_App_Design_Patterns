
package view;

import java.awt.event.*;
import javax.swing.*;
import logic.GUIfactory.*;
import logic.product.*;

public class HomeBuilder implements GUIBuilder {
    private JFrame window;
    private JPanel jpHome;
    private JLabel[] labels;
    private JButton[] buttons;
    private JComboBox[] comboBoxes;
    private GUIFactory factory;
    private Product[] product; // Hay que pensar en cómo transportar esta clase de datos
    
    public HomeBuilder(){
        this.factory = new HomeFactory();    
        this.product = new Product[9];
        this.product[0] = new Product("Computador portatil", 1700000, "./src/Resources/PC.jpg");
        this.product[0].setProductView(ProductViewFactory.getProductView(product[0], "Technology"));
        
        this.product[1] = new Product("Celular", 800000, "./src/Resources/Cellphone.jfif");
        this.product[1].setProductView(ProductViewFactory.getProductView(product[1], "Technology"));
        
        this.product[2] = new Product("Audífonos", 60000, "./src/Resources/Earphones.jpg");
        this.product[2].setProductView(ProductViewFactory.getProductView(product[2], "Technology"));
        
        this.product[3] = new Product("Camiseta", 40000, "./src/Resources/T-Shirt.jpg");
        this.product[3].setProductView(ProductViewFactory.getProductView(product[3], "Clothing"));
        
        this.product[4] = new Product("Jean", 50000, "./src/Resources/Jean.jpg");
        this.product[4].setProductView(ProductViewFactory.getProductView(product[4], "Clothing"));
        
        this.product[5] = new Product("Chaqueta de cuero", 75000, "./src/Resources/Jacket.jpg");
        this.product[5].setProductView(ProductViewFactory.getProductView(product[5], "Clothing"));
        
        this.product[6] = new Product("Sofá grande", 2500000, "./src/Resources/Sofa.jpg");
        this.product[6].setProductView(ProductViewFactory.getProductView(product[6], "Furniture"));
        
        this.product[7] = new Product("Silla con cojín", 370000, "./src/Resources/Chair.jfif");
        this.product[7].setProductView(ProductViewFactory.getProductView(product[7], "Furniture"));
        
        this.product[8] = new Product("Mesa de noche", 570000, "./src/Resources/Nightstand.jpg");
        this.product[8].setProductView(ProductViewFactory.getProductView(product[8], "Furniture"));
        
        for (Product p : product) p.getProductView().setBounds(20, 85, 350, 350);
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
        
        buttons[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        
        buttons[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnNextActionPerformed(evt);
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
                                .addComponent(product[0].getProductView(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addComponent(product[0].getProductView(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
    
    boolean band = true;
    
    private void cbSearchBarItemStateChanged(ItemEvent evt) { 
        int index = comboBoxes[0].getSelectedIndex();
        
        for (int i = 0; i < jpHome.getComponentCount(); i++) {
            if(jpHome.getComponent(i) == product[0].getProductView() || jpHome.getComponent(i) == product[3].getProductView() || jpHome.getComponent(i) == product[6].getProductView()){
                jpHome.remove(i);
                jpHome.repaint();
                System.out.println("Si");
            }
        }
        product[index].updateView();
        jpHome.add(product[index].getProductView());
        window.validate();
    } 
    
    private void btnPreviousActionPerformed(ActionEvent evt) {
        if(comboBoxes[0].getSelectedIndex() > 0){
            comboBoxes[0].setSelectedIndex(comboBoxes[0].getSelectedIndex()-1);
        }
    }
    
    private void btnNextActionPerformed(ActionEvent evt) {                                        
        if(comboBoxes[0].getSelectedIndex() < 8){
            comboBoxes[0].setSelectedIndex(comboBoxes[0].getSelectedIndex()+1);
        }
    }
}
