package logic.product;

public class Product implements Orderable {
    
    /*
    Nota: la marca, color y cantidad se settearán cuando se agrege el producto al carrito o se compre
    this.brand = productView.getCbBrand().getSelectedItem().toString();
    this.color = productView.getCbColor().getSelectedItem().toString();
    this.quantity = Integer.parseInt(productView.getCbQuantity().getSelectedItem().toString());
    */

    private String name, imagePath, color, brand;
    private int id, quantity;
    private int price;
    private ProductView productView;

    public Product(String name, int id, int price, String imagePath) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.imagePath = imagePath;
    }
    
    @Override
    public Orderable clone() {
        return new Product(name, id, price, imagePath);
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String getDetail() {
        return String.format(
                "Producto: %s \n" +
                "Precio: %.2f \n"
            ,name, price);
    }
    
    public String getStoreDetail() {
        return String.format(
                "Producto: %s \n" +
                "Cantidad: %d \n" +
                "Precio: %.2f \n"
            ,name, quantity, price);
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
