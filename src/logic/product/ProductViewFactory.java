
package logic.product;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class ProductViewFactory {
    private static HashMap<String, ProductView> productsViews = new HashMap<>();
    
    public static ProductView getProductView(String name, int price, String imagePath, String category) {
        ProductView result = productsViews.get(name);
        if (result == null) {
            result = createProductView(name, price, imagePath, category);
            productsViews.put(name, result);
        }
        return result;
    }
    
    private static ProductView createProductView(String name, int price, String imagePath, String category){
        ProductView newProductView = new ProductView();
       
        createComponents(newProductView, name, price, imagePath);
        setComboBoxes(newProductView.getCbBrand(), newProductView.getCbColor(), category);
        createPanel(newProductView);
        
        return newProductView;
    }
    
    private static void createComponents(ProductView p, String name, int price, String imagePath){      
        ImageIcon img = new ImageIcon(imagePath);        
        p.getLabel(0).setIcon(new ImageIcon(img.getImage().getScaledInstance(290, 150, Image.SCALE_SMOOTH)));
        
        p.getLabel(1).setFont(new Font("Lucida Fax", 0, 14)); 
        p.getLabel(1).setText("Nombre: "+name);

        p.getLabel(2).setFont(new Font("Lucida Fax", 0, 14)); 
        p.getLabel(2).setText("Marca:");    
        
        p.getCbBrand().setFont(new Font("Lucida Fax", 0, 12)); 
        
        p.getLabel(3).setFont(new Font("Lucida Fax", 0, 14)); 
        p.getLabel(3).setText("Color:");
        
        p.getCbColor().setFont(new Font("Lucida Fax", 0, 12)); 
        
        p.getLabel(4).setFont(new Font("Lucida Fax", 0, 14)); 
        p.getLabel(4).setText("Precio: $"+price);

        p.getLabel(5).setFont(new Font("Lucida Fax", 0, 14)); 
        p.getLabel(5).setText("Cantidad:");        
        
        p.getCbQuantity().setFont(new Font("Lucida Fax", 0, 12)); 
        p.getCbQuantity().setModel(new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
    }
    
    public static void setComboBoxes(JComboBox brands, JComboBox colors, String category){
        switch(category){
            case "Technology":
                brands.setModel(new DefaultComboBoxModel<>(new String[] { "Samsung", "Huawei", "Apple" }));
                colors.setModel(new DefaultComboBoxModel<>(new String[] { "Black", "White", "Silver" }));
                break;
            case "Clothing":
                brands.setModel(new DefaultComboBoxModel<>(new String[] { "Koaj", "Adidas", "Nike" }));
                colors.setModel(new DefaultComboBoxModel<>(new String[] { "Black", "White", "Yellow", "Blue", "Red", "Green" }));
                break;
            case "Furniture":
                brands.setModel(new DefaultComboBoxModel<>(new String[] { "Jamar", "Moderline", "Series" }));
                colors.setModel(new DefaultComboBoxModel<>(new String[] { "Black", "Gray", "Blue", "Red", "Green", "Pink" }));
                break;
            default: break;
        }
    }
    
    private static void createPanel(ProductView p){
        GroupLayout jpProductLayout = new GroupLayout(p);
        p.setLayout(jpProductLayout);
        jpProductLayout.setHorizontalGroup(
            jpProductLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(p.getLabel(0), GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpProductLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(p.getLabel(1))
                    .addComponent(p.getLabel(4))
                    .addGroup(jpProductLayout.createSequentialGroup()
                        .addComponent(p.getLabel(5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p.getCbQuantity(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpProductLayout.createSequentialGroup()
                        .addComponent(p.getLabel(3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(p.getCbColor(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpProductLayout.createSequentialGroup()
                        .addComponent(p.getLabel(2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(p.getCbBrand(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpProductLayout.setVerticalGroup(
            jpProductLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpProductLayout.createSequentialGroup()
                .addComponent(p.getLabel(0), GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p.getLabel(1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProductLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(p.getLabel(2))
                    .addComponent(p.getCbBrand(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProductLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(p.getLabel(3))
                    .addComponent(p.getCbColor(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p.getLabel(4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProductLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(p.getLabel(5))
                    .addComponent(p.getCbQuantity(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }
}
