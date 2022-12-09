package db;

import logic.product.Purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseDAO {
    
    private Connection connection;
    private PreparedStatement preQuery;
    private boolean isSuccesfully;
    private ArrayList<Purchase> purchases;
    
     private final String[] QUERIES = {
        "INSERT INTO purchase (id, account_id, total_price, payment_method) VALUES (?,?,?,?);",
        "INSERT INTO purchase_product (purchase_id, product_id) VALUES (?,?);",
        "SELECT id, account_id, total_price, payment_method FROM purchase WHERE account_id = ?;",
        "SELECT product_id FROM purchase_product WHERE purchase_id = ?;"
    };
    
    public PurchaseDAO() {
        connection = DBConnection.getInstance().getConnection();
        purchases = new ArrayList();
    }
    
    public boolean create(Purchase purchase){
        try {
            preQuery = connection.prepareStatement(QUERIES[0]);
            
            preQuery.setInt(1, purchase.getId());
            preQuery.setInt(2, purchase.getAccountId());
            preQuery.setDouble(3, purchase.getTotalPrice());
            preQuery.setString(4, purchase.getPaymentMethod());
            
            if (preQuery.executeUpdate() > 0){
                isSuccesfully = true;
            }
            
        } catch(SQLException ex){
            isSuccesfully = false;
        }
        return isSuccesfully;
    }
    
    /**
     * Asocia un producto a una compra realizada
     * @param purchaseId
     * @param productId
     * @return 
     */
    public boolean addProduct(int purchaseId, int productId){
        try {
            preQuery = connection.prepareStatement(QUERIES[1]);
            
            preQuery.setInt(1, purchaseId);
            preQuery.setInt(2, productId);
            
            if (preQuery.executeUpdate() > 0){
                isSuccesfully = true;
            }
            
        } catch(SQLException ex){
            isSuccesfully = false;
        }
        return isSuccesfully;
    }
    
    public ArrayList<Purchase> getAllByAccountId(int accountId) {
        try {
            purchases.clear();
            preQuery = connection.prepareStatement(QUERIES[2]);
            preQuery.setInt(1, accountId);
            ResultSet data = preQuery.executeQuery();

            while (data.next()) {
                Purchase p = new Purchase(
                        data.getInt("id"),
                        data.getInt("account_id"),
                        data.getString("payment_method"),
                        new ArrayList(),
                        data.getDouble("total_price"));
                purchases.add(p);
            }

        } catch (SQLException ex) {
            purchases.clear();
        }
        return purchases;
    }
    
    /**
     * 
     * @param purchaseId
     * @return un ArrayList con los ids de todos los productos asociados a una compra
     */
    public ArrayList<Integer> getProductsIdByPurchase(int purchaseId) {
        ArrayList<Integer> productsIds = new ArrayList();
        try {
            preQuery = connection.prepareStatement(QUERIES[3]);
            preQuery.setInt(1, purchaseId);
            ResultSet data = preQuery.executeQuery();

            while (data.next()) {
                productsIds.add(data.getInt("product_id"));
            }

        } catch (SQLException ex) {
            productsIds.clear();
        }
        return productsIds;
    }
    
}
