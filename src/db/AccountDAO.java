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
        "INSERT INTO account (id, points) VALUES (?,?);",
        "SELECT id, points FROM account WHERE id = ?:",
        "UPDATE account SET points = ? WHERE id = ?;"
    };
    
    public AccountDAO() {
        connection = DBConnection.getInstance().getConnection();
        account = new Account();
    }
    
    public boolean create(Account account){
        try {
            preQuery = connection.prepareStatement(QUERIES[1]);
            
            preQuery.setInt(1, account.getId());
            preQuery.setInt(2, account.getPoints());
            
            if (preQuery.executeUpdate() > 0){
                isSuccesfully = true;
            }
            
        } catch(SQLException ex){
            isSuccesfully = false;
        }
        return isSuccesfully;
    }
    
    public Account get(int accountId){
        try {
            preQuery = connection.prepareStatement(QUERIES[1]);

            preQuery.setInt(1, accountId);
            ResultSet data = preQuery.executeQuery();

            if (data.next()) {
                account.setId(data.getInt("id"));
                account.setPoints(data.getInt("points"));
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
            preQuery.setInt(2, account.getId());
            
            if (preQuery.executeUpdate() > 0){
                isSuccesfully = true;
            }
            
        } catch(SQLException ex){
            isSuccesfully = false;
        }
        return isSuccesfully;
    }
}
