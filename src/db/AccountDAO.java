package db;

import logic.account.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    
    private Connection connection;
    private PreparedStatement preQuery;
    private boolean isSuccesfully;
    private Account account;
    
    private final String[] QUERIES = {
        "INSERT INTO accounts (user_id, points, b_discount, b_extra_points, b_free_delivery) VALUES (?,?,?,?,?);",
        "SELECT id, user_id, points, b_discount, b_extra_points, b_free_delivery FROM accounts WHERE user_id = ?;",
        "UPDATE accounts SET points=?, b_discount=?, b_extra_points=?, b_free_delivery=? WHERE id = ?;"
    };
    
    public AccountDAO() {
        connection = DBConnection.getInstance().getConnection();
    }
    
    public boolean create(Account account){
        try {
            preQuery = connection.prepareStatement(QUERIES[0]);

            preQuery.setString(1, account.getUserId());
            preQuery.setInt(2, account.getPoints());
            preQuery.setBoolean(3, false);
            preQuery.setBoolean(4, false);
            preQuery.setBoolean(5, false);
            
            if (preQuery.executeUpdate() > 0){
                isSuccesfully = true;
            }
            
        } catch(SQLException ex){
            isSuccesfully = false;
        }
        return isSuccesfully;
    }
    
    public Account getByUserId(String userId){
        try {
            account = new Account();
            preQuery = connection.prepareStatement(QUERIES[1]);

            preQuery.setString(1, userId);
            ResultSet data = preQuery.executeQuery();

            if (data.next()) {
                account.setId(data.getInt("id"));
                account.setUserId(data.getString("user_id"));
                account.setPoints(data.getInt("points"));
                account.setDiscount(data.getBoolean("b_discount"));
                account.setExtraPoints(data.getBoolean("b_extra_points"));
                account.setFreeDelivery(data.getBoolean("b_free_delivery"));
            }

        } catch (SQLException ex) {
            account = null;
        }
        return account;
    }
    
    public boolean update(Account account){
        try {
            preQuery = connection.prepareStatement(QUERIES[2]);
            
            preQuery.setInt(1, account.getPoints());
            preQuery.setBoolean(2, account.isDiscount());
            preQuery.setBoolean(3, account.isExtraPoints());
            preQuery.setBoolean(4, account.isFreeDelivery());
            preQuery.setInt(5, account.getId());
            
            if (preQuery.executeUpdate() > 0){
                isSuccesfully = true;
            }
            
        } catch(SQLException ex){
            isSuccesfully = false;
        }
        return isSuccesfully;
    }
}
