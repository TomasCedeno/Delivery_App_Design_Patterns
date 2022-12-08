
package logic.GUIfactory;

import java.awt.*;
import javax.swing.*;

public class LoginFactory implements GUIFactory {

    @Override
    public JLabel[] createLabels() {
        JLabel[] labels = new JLabel[4];
        labels[0] = new JLabel();
        labels[1] = new JLabel();
        labels[2] = new JLabel();
        labels[3] = new JLabel();
        
        labels[0].setFont(new Font("Lucida Fax", 1, 48));
        labels[0].setText("HAWK SHIPPING");
        
        labels[1].setFont(new Font("Lucida Fax", 0, 14));
        labels[1].setText("<html> <p text-aling: center>Bienvenido a nuestra app de envíos,<br>inicia sesión con tu cuenta o crea una nueva<br>para disfrutar de nuestros servicios.</p> </html>");
        
        labels[2].setFont(new Font("Lucida Fax", 0, 14));
        labels[2].setText("E-mail:");
        
        labels[3].setFont(new Font("Lucida Fax", 0, 14));
        labels[3].setText("Contraseña:");
        
        return labels;
    }

    @Override
    public JButton[] createButtons() {
        JButton[] buttons = new JButton[2];
        buttons[0] = new JButton();
        buttons[1] = new JButton();
        
        buttons[0] = new JButton();
        buttons[1] = new JButton();
        
        buttons[0].setFont(new Font("Lucida Fax", 0, 14));
        buttons[0].setText("Iniciar sesión");
        
        buttons[1].setFont(new Font("Lucida Fax", 0, 14));
        buttons[1].setText("Registrarse");
        
        return buttons;
    }

    @Override
    public JTextField[] createTextFields() {
        JTextField[] textFields = new JTextField[2];
        textFields[0] = new JTextField();
        textFields[1] = new JTextField();
        
        textFields[0] = new JTextField();
        textFields[1] = new JTextField();
        
        return textFields;
    }
    
}
