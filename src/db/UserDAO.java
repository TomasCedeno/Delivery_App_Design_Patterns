package db;

import logic.account.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
   
    private Connection connection;
    private PreparedStatement preQuery;
    private boolean isSuccesfully;
    private User user;
    
    private final String[] QUERIES = {
        "INSERT INTO users (identification, email, password, name, last_name, address, birth_day) VALUES (?,?,?,?,?,?,?);",
        "SELECT identification, email, password, name, last_name, address, birth_day FROM users WHERE identification = ?;",
        "SELECT identification, email, password, name, last_name, address, birth_day FROM users WHERE email = ?;",
        "UPDATE users SET password = ?, address = ? WHERE identification = ?"
    };
    
    public UserDAO() {
        connection = DBConnection.getInstance().getConnection();
    }
    
    public boolean create(User user){
        try {
            preQuery = connection.prepareStatement(QUERIES[0]);
            
            preQuery.setString(1, user.getIdentification());
            preQuery.setString(2, user.getEmail());
            preQuery.setString(3, user.getPassword());
            preQuery.setString(4, user.getName());
            preQuery.setString(5, user.getLastName());
            preQuery.setString(6, user.getAddress());
            preQuery.setString(7, user.getBirthDay());
            
            if (preQuery.executeUpdate() > 0){
                isSuccesfully = true;
            }
            
        } catch(SQLException ex){
            isSuccesfully = false;
        }
        return isSuccesfully;
    }
    
    
    public User getByIdentification(String userId){
        try {
            user = new User("", "");
            preQuery = connection.prepareStatement(QUERIES[1]);
            
            preQuery.setString(1, userId);
            ResultSet data = preQuery.executeQuery();
            
            if (data.next()) {
                user.setIdentification(data.getString("identification"));
                user.setEmail(data.getString("email"));
                user.setPassword(data.getString("password"));
                user.setName(data.getString("name"));
                user.setLastName(data.getString("last_name"));
                user.setAddress(data.getString("address"));
                user.setBirthDay(data.getString("birth_day"));
            }
            
        } catch(SQLException ex){
            user = null;
        }
        return user;
    }
    
    public User getByEmail(String email){
        try {
            user = new User("", "");
            preQuery = connection.prepareStatement(QUERIES[2]);
            
            preQuery.setString(1, email);
            ResultSet data = preQuery.executeQuery();
            
            if (data.next()) {
                user.setIdentification(data.getString("identification"));
                user.setEmail(data.getString("email"));
                user.setPassword(data.getString("password"));
                user.setName(data.getString("name"));
                user.setLastName(data.getString("last_name"));
                user.setAddress(data.getString("address"));
                user.setBirthDay(data.getString("birth_day"));
            }
            
        } catch(SQLException ex){
            user = null;
        }
        return user;
    }
    
    public boolean update(User user){
        try {
            preQuery = connection.prepareStatement(QUERIES[3]);
            
            preQuery.setString(1, user.getPassword());
            preQuery.setString(2, user.getAddress());
            preQuery.setString(3, user.getIdentification());
            
            if (preQuery.executeUpdate() > 0){
                isSuccesfully = true;
            }
            
        } catch(SQLException ex){
            isSuccesfully = false;
        }
        return isSuccesfully;
    }
    
}
