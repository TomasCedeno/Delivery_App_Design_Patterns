package logic.GUIfactory;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AccountFactory implements GUIFactory {

    @Override
    public JLabel[] createLabels() {
        JLabel[] labels = new JLabel[12];
        labels[0] = new javax.swing.JLabel();
        labels[1] = new javax.swing.JLabel();
        labels[2] = new javax.swing.JLabel();
        labels[3] = new javax.swing.JLabel();
        labels[4] = new javax.swing.JLabel();
        labels[5] = new javax.swing.JLabel();
        labels[6] = new javax.swing.JLabel();
        labels[7] = new javax.swing.JLabel();
        labels[8] = new javax.swing.JLabel();
        labels[9] = new javax.swing.JLabel();
        labels[10] = new javax.swing.JLabel();
        labels[11] = new javax.swing.JLabel();
        
        labels[0].setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        labels[0].setText("Detalle Compra");
        
        labels[1].setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        labels[1].setText("Nombre: ");

        labels[2].setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        labels[2].setText("Cuenta");

        labels[3].setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        labels[3].setText("Fecha de Nacimiento: ");

        labels[4].setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        labels[4].setText("Apellido: ");

        labels[5].setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        labels[5].setText("Contraseña:");

        labels[6].setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        labels[6].setText("Dirección: ");

        labels[7].setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        labels[7].setText("Email:");

        labels[8].setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        labels[8].setText("Identificación:");
        
        labels[9].setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        labels[9].setText("Historial Compras");
        
        labels[10].setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        labels[10].setText("Puntos: ");
        
        labels[11].setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        labels[11].setText("Mejora tu cuenta");
        
        return labels;
    }

    @Override
    public JButton[] createButtons() {
        JButton[] buttons = new JButton[7];
        buttons[0] = new javax.swing.JButton();
        buttons[1] = new javax.swing.JButton();
        buttons[2] = new javax.swing.JButton();
        buttons[3] = new javax.swing.JButton();
        buttons[4] = new javax.swing.JButton();
        buttons[5] = new javax.swing.JButton();
        buttons[6] = new javax.swing.JButton();
        
        buttons[0].setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        buttons[0].setText("Inicio");

        buttons[1].setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        buttons[1].setText("Carrito");

        buttons[2].setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        buttons[2].setText("Actualizar Datos");
        
        buttons[3].setFont(new java.awt.Font("Lucida Fax", 0, 12)); // NOI18N
        buttons[3].setText("Cuenta");
        
        buttons[4].setText("Descuentos");

        buttons[5].setText("Entrega Gratis");

        buttons[6].setText("Puntos Extra");
        
        return buttons;
    }

    @Override
    public JComboBox[] createComboBoxes() {return null;}

    @Override
    public JTextField[] createTextFields() {
        JTextField[] textFileds = new JTextField[3];
        textFileds[0] = new javax.swing.JTextField();
        textFileds[1] = new javax.swing.JTextField();
        textFileds[2] = new javax.swing.JPasswordField();
        
        textFileds[0].setEditable(false);
        
        return textFileds;
    }
    
}
