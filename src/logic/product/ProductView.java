
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
    
    public void updateView(String imagePath, String name, int price, String category){
        ImageIcon img = new ImageIcon(imagePath);   
        labels[0].setIcon(new ImageIcon(img.getImage().getScaledInstance(290, 150, Image.SCALE_SMOOTH)));
        labels[1].setText("Nombre: " + name);
        labels[4].setText("Precio: $" + price);
        
        switch(category){
            case "Technology":
                cbBrand.setModel(new DefaultComboBoxModel<>(new String[] { "Samsung", "Huawei", "Apple" }));
                cbColor.setModel(new DefaultComboBoxModel<>(new String[] { "Black", "White", "Silver" }));
                break;
            case "Clothing":
                cbBrand.setModel(new DefaultComboBoxModel<>(new String[] { "Koaj", "Adidas", "Nike" }));
                cbColor.setModel(new DefaultComboBoxModel<>(new String[] { "Black", "White", "Yellow", "Blue", "Red", "Green" }));
                break;
            case "Furniture":
                cbBrand.setModel(new DefaultComboBoxModel<>(new String[] { "Jamar", "Moderline", "Series" }));
                cbColor.setModel(new DefaultComboBoxModel<>(new String[] { "Black", "Gray", "Blue", "Red", "Green", "Pink" }));
                break;
            default: break;
        }
    }
}
