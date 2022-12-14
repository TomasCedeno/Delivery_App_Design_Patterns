package logic.product;

public class Product implements Orderable {

    private String name, imagePath, color, brand;
    private int quantity;
    private int price;
    private ProductView productView;

    public Product(String name, int price, String imagePath) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
        this.quantity = 1;
    }
    
    @Override
    public Orderable clone() {
        Product p = new Product(name, price, imagePath);
        p.setProductView(productView);
        
        return p;
    }

    @Override
    public int getPrice() {
        return this.price * this.quantity;
    }

    @Override
    public String getDetail() {
        return String.format(
                "Producto: %s \n" +
                "Color: %s \n" +
                "Marca: %s \n" +
                "Cantidad: %d \n" +
                "Precio: %d \n"
            ,name, color, brand, quantity, price);
    }

    public void setPrice(int price) {
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
    
    @Override
    public void add(Product element) { }

    @Override
    public Product remove(int index) {
        return null;
    }

    @Override
    public Orderable getElement(int index) {
        return null;
    } 

    public ProductView getProductView() {
        return productView;
    }

    public void setProductView(ProductView productView) {
        this.productView = productView;
    }
    
    public void updateView(){
        productView.updateView(this);
    }
}
