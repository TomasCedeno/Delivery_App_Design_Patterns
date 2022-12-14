
package logic.GUIfactory;

import java.awt.*;
import javax.swing.*;

public class CartFactory implements GUIFactory {

    @Override
    public JLabel[] createLabels() {
        JLabel[] labels = new JLabel[1];
        labels[0] = new JLabel();
        
        labels[0].setFont(new Font("Lucida Fax", 0, 18));
        labels[0].setText("Cart");
        
        return labels;
    }

    @Override
    public JButton[] createButtons() {
        JButton[] buttons = new JButton[7];
        buttons[0] = new JButton();
        buttons[1] = new JButton();
        buttons[2] = new JButton();
        buttons[3] = new JButton();
        buttons[4] = new JButton();
        buttons[5] = new JButton();
        buttons[6] = new JButton();
        
        buttons[0].setFont(new Font("Cooper Black", 1, 18)); 
        buttons[0].setText("<");
        
        buttons[1].setFont(new Font("Cooper Black", 1, 18)); 
        buttons[1].setText(">");
        
        buttons[2].setFont(new Font("Lucida Fax", 0, 14)); 
        buttons[2].setText("Comprar");

        buttons[3].setFont(new Font("Lucida Fax", 0, 14)); 
        buttons[3].setText("Eliminar");
        
        buttons[4].setFont(new Font("Lucida Fax", 0, 12)); 
        buttons[4].setText("Inicio");

        buttons[5].setFont(new Font("Lucida Fax", 0, 12)); 
        buttons[5].setText("Carrito");

        buttons[6].setFont(new Font("Lucida Fax", 0, 12)); 
        buttons[6].setText("Cuenta");
        
        return buttons;
    }

    @Override
    public JComboBox[] createComboBoxes() { return null; }

    @Override
    public JTextField[] createTextFields() { return null; }
    
}
