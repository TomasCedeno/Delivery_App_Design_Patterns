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
        "INSERT INTO purchases (account_id, total_price, payment_method) VALUES (?,?,?);",
        "SELECT id, account_id, total_price, payment_method FROM purchases WHERE account_id = ? ORDER BY id DESC;",
    };
    
    public PurchaseDAO() {
        connection = DBConnection.getInstance().getConnection();
        purchases = new ArrayList();
    }
    
    public boolean create(Purchase purchase){
        try {
            preQuery = connection.prepareStatement(QUERIES[0]);
            
            preQuery.setInt(1, purchase.getAccountId());
            preQuery.setInt(2, purchase.getTotalPrice());
            preQuery.setString(3, purchase.getPaymentMethod());
            
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
            preQuery = connection.prepareStatement(QUERIES[1]);
            preQuery.setInt(1, accountId);
            ResultSet data = preQuery.executeQuery();

            while (data.next()) {
                Purchase p = new Purchase(
                        data.getInt("id"),
                        data.getInt("account_id"),
                        data.getString("payment_method"),
                        data.getInt("total_price"));
                p.setProducts(new ArrayList());
                purchases.add(p);
            }

        } catch (SQLException ex) {
            purchases.clear();
        }
        return purchases;
    }
       
}
