
package logic.GUIfactory;

import javax.swing.*;

public interface GUIFactory {
    public JLabel[] createLabels();
    public JButton[] createButtons();
    public JComboBox[] createComboBoxes();
    public JTextField[] createTextFields();
}
