package logic.product;

public class Product implements Orderable {

    private String name;
    private int id;
    private double price;
    private int quantity;
    private String imagePath; //Se puede cambiar por un campo de tipo imagen (Image)
    private String description;

    public Product(int id, String name, double price, int quantity, String imagePath, String description) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = imagePath;
        this.description = description;
    }
    
    @Override
    public Orderable clone() {
        return new Product(id, name, price, quantity, imagePath, description);
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getDetail() {
        return String.format(
                "Producto: %s \n" +
                "Descripción: %s \n" +
                "Precio: %.2f \n"
            ,name, price, description);
    }
    
    public String getStoreDetail() {
        return String.format(
                "Producto: %s \n" +
                "Cantidad: %d \n" +
                "Descripción: %s \n" +
                "Precio: %.2f \n"
            ,name, quantity, price, description);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public void add(Orderable element) {
    }

    @Override
    public Orderable remove(int index) {
        return null;
    }

    @Override
    public Orderable getElement(int index) {
        return null;
    } 
}
