package logic.product;

import java.util.ArrayList;

public class Purchase {
    
    private int id, accountId, totalPrice;
    private String paymentMethod;
    private ArrayList<Product> products;

    public Purchase(int id, int accountId, String paymentMethod, int totalPrice) {
        this.id = id;
        this.accountId = accountId;
        this.paymentMethod = paymentMethod;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
    public void addProduct(Product product) {
        this.products.add(product);
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public String getProductsDetail() {
        String detail = "";
        for (Product p: products){
            detail += p.getDetail() + "\n";
        }
        return detail;
    }
    
    public String[] toArray() {
        String[] data = {String.valueOf(id), String.valueOf(totalPrice), paymentMethod};
        return data;
    }
}
