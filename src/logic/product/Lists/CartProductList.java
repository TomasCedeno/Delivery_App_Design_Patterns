
package logic.product.Lists;

import java.util.ArrayList;
import logic.product.*;

public class CartProductList implements ProductList {
    private ArrayList<Product> products;
    
    public CartProductList() {
        products = new ArrayList<>();
        
        products.add(0, new Product("Computador portatil", 1700000, "./src/Resources/PC.jpg"));
        products.get(0).setProductView(ProductViewFactory.getProductView(products.get(0), "Technology"));
                
        products.add(1, new Product("Jean", 50000, "./src/Resources/Jean.jpg"));
        products.get(1).setProductView(ProductViewFactory.getProductView(products.get(1), "Clothing"));
        
        products.add(2, new Product("Mesa de noche", 570000, "./src/Resources/Nightstand.jpg"));
        products.get(2).setProductView(ProductViewFactory.getProductView(products.get(2), "Furniture"));
        
        for (Product p : products) p.getProductView().setBounds(20, 60, 350, 350);
    }

    @Override
    public Iterator createUpIterator() {
        return new UpIterator(this);
    }

    @Override
    public Iterator createDownIterator() {
        return new DownIterator(this);
    }

    @Override
    public ArrayList<Product> getProducts() {
        return this.products;
    }    
}
