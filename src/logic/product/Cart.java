
package logic.product;

import java.util.ArrayList;

public class Cart implements Orderable{
    
    private ArrayList<Orderable> elements;

    public Cart() {
        this.elements = new ArrayList<>();
    }
    
    @Override
    public Orderable clone() {
        Orderable orderCopy = new Order();
        
        for(Orderable e: elements){
            orderCopy.add(e.clone());
        }
        
        return orderCopy;
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
    public void add(Orderable element) {
        this.elements.add(element);
    }

    @Override
    public Orderable remove(int index) {
        return this.remove(index);
    }

    @Override
    public Orderable getElement(int index) {
        return this.elements.get(index);
    }
    
}
