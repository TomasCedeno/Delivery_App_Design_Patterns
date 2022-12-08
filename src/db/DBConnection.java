package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private static DBConnection instance;
    private Connection connection;
    private final String URL = "jdbc:postgresql://localhost:5432/hawk";
    private final String USER = "user";
    private final String PASSWORD = "password";
    
    private DBConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado!");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            System.out.println("OK ");
        }
    }
    
    //Singleton
    public static DBConnection getInstance(){
        if (instance == null ){
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}