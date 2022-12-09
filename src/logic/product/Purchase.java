package logic.product;

import java.util.ArrayList;

public class Purchase {
    
    private int id, accountId;
    private String paymentMethod;
    private ArrayList<Product> products;
    private double totalPrice;

    public Purchase(int id, int accountId, String paymentMethod, ArrayList<Product> products, double totalPrice) {
        this.id = id;
        this.accountId = accountId;
        this.paymentMethod = paymentMethod;
        this.products = products;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
    
    
}
