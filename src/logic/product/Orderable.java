package logic.product;

public interface Orderable {
    
    public abstract Orderable clone();
    public abstract double getPrice();
    public abstract String getDetail();
    public abstract void add(Orderable element);
    public abstract Orderable remove(int index);
    public abstract Orderable getElement(int index);
 
}
