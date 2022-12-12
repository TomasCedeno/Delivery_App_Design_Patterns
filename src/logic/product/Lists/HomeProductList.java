
package logic.product.Lists;

import java.util.ArrayList;
import logic.product.*;

public class HomeProductList implements ProductList{
    private ArrayList<Product> products;
    
    public HomeProductList() {
        products = new ArrayList<>();
        
        products.add(0, new Product("Computador portatil", 1700000, "./src/Resources/PC.jpg"));
        products.get(0).setProductView(ProductViewFactory.getProductView(products.get(0), "Technology"));
        
        products.add(1, new Product("Celular", 800000, "./src/Resources/Cellphone.jfif"));
        products.get(1).setProductView(ProductViewFactory.getProductView(products.get(1), "Technology"));
        
        products.add(2, new Product("Audífonos", 60000, "./src/Resources/Earphones.jpg"));
        products.get(2).setProductView(ProductViewFactory.getProductView(products.get(2), "Technology"));
        
        products.add(3, new Product("Camiseta", 40000, "./src/Resources/T-Shirt.jpg"));
        products.get(3).setProductView(ProductViewFactory.getProductView(products.get(3), "Clothing"));
        
        products.add(4, new Product("Jean", 50000, "./src/Resources/Jean.jpg"));
        products.get(4).setProductView(ProductViewFactory.getProductView(products.get(4), "Clothing"));
        
        products.add(5, new Product("Chaqueta de cuero", 75000, "./src/Resources/Jacket.jpg"));
        products.get(5).setProductView(ProductViewFactory.getProductView(products.get(5), "Clothing"));
        
        products.add(6, new Product("Sofá grande", 2500000, "./src/Resources/Sofa.jpg"));
        products.get(6).setProductView(ProductViewFactory.getProductView(products.get(6), "Furniture"));
        
        products.add(7, new Product("Silla con cojín", 370000, "./src/Resources/Chair.jfif"));
        products.get(7).setProductView(ProductViewFactory.getProductView(products.get(7), "Furniture"));
        
        products.add(8, new Product("Mesa de noche", 570000, "./src/Resources/Nightstand.jpg"));
        products.get(8).setProductView(ProductViewFactory.getProductView(products.get(8), "Furniture"));
        
        for (Product p : products) p.getProductView().setBounds(20, 85, 350, 350);
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
