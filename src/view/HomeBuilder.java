
package view;

import java.awt.event.*;
import javax.swing.*;
import logic.GUIfactory.*;
import logic.product.*;

public class HomeBuilder implements GUIBuilder {
    private JFrame window;
    private JLabel[] labels;
    private JButton[] buttons;
    private JComboBox[] comboBoxes;
    private GUIFactory factory;
    private Product product; // Hay que pensar en cómo transportar esta clase de datos
    
    public HomeBuilder(){
        factory = new HomeFactory();     
        product = new Product("Computador portatil", 0, 1700000, "./src/Resources/PC.jpg", "Technology");
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
                cbSearchBarItemStateChanged(evt);
            }
        });
        
        buttons[0].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        
        buttons[1].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
    }
    
    @Override
    public void createWindow() {
        this.window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel jpHome = new JPanel();  
        
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
                                .addComponent(product.getProductView(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addComponent(product.getProductView(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jpHomeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttons[0])
                    .addComponent(buttons[3])
                    .addComponent(buttons[2])
                    .addComponent(buttons[1]))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
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
    
    private void cbSearchBarItemStateChanged(ItemEvent evt) {                                             
        String key = comboBoxes[0].getSelectedItem().toString();
        ImageIcon img;
        switch(key){
            case "Computador":
                product.updateProduct("Computador Portatil", 0, 1700000, "./src/Resources/PC.jpg", "Technology");
                window.validate();
                break;
            case "Celular":
                product.updateProduct("Celular", 1, 800000, "./src/Resources/Cellphone.jfif", "Technology");
                window.validate();
                break;
            case "Audífonos":
                product.updateProduct("Audífonos", 2, 60000,"./src/Resources/Earphones.jpg", "Technology");
                window.validate();
                break;
            case "Camiseta":
                product.updateProduct("Camiseta", 3, 40000, "./src/Resources/T-Shirt.jpg", "Clothing");
                window.validate();
                break;
            case "Jean":
                product.updateProduct("Jean", 4, 50000, "./src/Resources/Jean.jpg", "Clothing");
                window.validate();
                break;
            case "Chaqueta":
                product.updateProduct("Chaqueta de cuero", 5, 75000, "./src/Resources/Jacket.jpg", "Clothing");
                window.validate();
                break;
            case "Sofá":
                product.updateProduct("Sofa grande", 6, 2500000, "./src/Resources/Sofa.jpg", "Furniture");
                window.validate();
                break;
            case "Silla":
                product.updateProduct("Nombre: Silla con cojin", 7, 370000, "./src/Resources/Chair.jfif", "Furniture");
                window.validate();
                break;
            default:
                product.updateProduct("Mesa de noche", 8, 570000, "./src/Resources/Nightstand.jpg", "Furniture");
                window.validate();
                break;
        }
    } 
    
    private void btnPreviousActionPerformed(ActionEvent evt) {
        if(product.getId() > 0){
            comboBoxes[0].setSelectedIndex(product.getId()-1);
            cbSearchBarItemStateChanged(null);
        }
    }
    
    private void btnNextActionPerformed(ActionEvent evt) {                                        
        if(product.getId() < 8){
            comboBoxes[0].setSelectedIndex(product.getId()+1);
            cbSearchBarItemStateChanged(null);
        }
    }
}
