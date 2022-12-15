
package logic.product;

import java.util.ArrayList;
import logic.product.Lists.*;

public class Cart implements Orderable, ProductList {
    
    private ArrayList<Product> elements;

    public Cart() {
        this.elements = new ArrayList<>();
    }
    
    @Override
    public Orderable clone() {
        Cart cartCopy = new Cart();
        
        for(Product e: elements){
            cartCopy.add((Product) e.clone());
        }
        
        return cartCopy;
    }

    @Override
    public int getPrice() {
        int totalPrice = 0;
        
        for(Orderable e: elements){
            totalPrice += e.getPrice();
        }
        
        return totalPrice;
    }

    @Override
    public String getDetail() {
        String detail = "";
        
        for (Orderable e: elements){
            detail += e.getDetail() + "\n";
        }
        
        detail += "Precio total: " + this.getPrice();
        
        return detail;
    }

    @Override
    public void add(Product element) {
        this.elements.add(element);
    }

    @Override
    public Orderable remove(int index) {
        return this.elements.remove(index);
    }

    @Override
    public Product getElement(int index) {
        return this.elements.get(index);
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
        return this.elements;
    } 
}
