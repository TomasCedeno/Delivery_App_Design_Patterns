
package view;

import javax.swing.JFrame;

public interface GUIBuilder {
    public void createLabels();
    public void createButtons();
    public void createComboBoxes();
    public void createTextFields();
    public void addEvents();
    public void createWindow();
    public JFrame getFrame();
}
