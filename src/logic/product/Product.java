package logic.product;

public class Product implements Orderable {

    private String name, imagePath, description, color, brand;
    private int id, quantity;
    private double price;

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
            ,name, description, price);
    }
    
    public String getStoreDetail() {
        return String.format(
                "Producto: %s \n" +
                "Cantidad: %d \n" +
                "Descripción: %s \n" +
                "Precio: %.2f \n"
            ,name, quantity, description, price);
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
