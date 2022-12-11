
package logic.product;

import java.awt.Image;
import javax.swing.*;

public class ProductView extends JPanel{
    private JComboBox<String> cbColor;
    private JComboBox<String> cbBrand;
    private JComboBox<String> cbQuantity;
    private JLabel[] labels;
    
    public ProductView(){
        cbColor = new JComboBox<>();
        cbBrand = new JComboBox<>();
        cbQuantity = new JComboBox<>();
        labels = new JLabel[6];
        labels[0] = new JLabel();
        labels[1] = new JLabel();
        labels[2] = new JLabel();
        labels[3] = new JLabel();
        labels[4] = new JLabel();
        labels[5] = new JLabel();
    }

    public JComboBox<String> getCbColor() {
        return cbColor;
    }

    public JComboBox<String> getCbBrand() {
        return cbBrand;
    }

    public JComboBox<String> getCbQuantity() {
        return cbQuantity;
    }

    public JLabel getLabel(int index) {
        return labels[index];
    }
    
    public void updateView(Product product){
        ImageIcon img = new ImageIcon(product.getImagePath());   
        labels[0].setIcon(new ImageIcon(img.getImage().getScaledInstance(290, 150, Image.SCALE_SMOOTH)));
        labels[1].setText("Nombre: " + product.getName());
        labels[4].setText("Precio: $" + product.getPrice());
    }
}
