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
    private final String USER = "postgres";
    private final String PASSWORD = "bdpostgre1608";
    
    private DBConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
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