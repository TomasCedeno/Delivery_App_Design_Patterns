package db;

import logic.product.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
    
    private Connection connection;
    private PreparedStatement preQuery;
    private boolean isSuccesfully;
    private ArrayList<Product> products;
    
    private final String[] QUERIES = {
        "INSERT INTO products (purchase_id, name, price, image_path, quantity, color, brand) VALUES (?,?,?,?,?,?,?);",
        "SELECT name, price, image_path, quantity, color, brand FROM products WHERE purchase_id = ?;"
    };

    public ProductDAO() {
        connection = DBConnection.getInstance().getConnection();
        products = new ArrayList();
    }
    
    /**
     * Crea un producto en la base de datos asociandolo a una compra en especifico
     * @param product
     * @param purchaseId
     * @return true o false dependiendo del exito de la operacion
     */
    public boolean create(Product product, int purchaseId) {
        try {
            preQuery = connection.prepareStatement(QUERIES[0]);
            
            preQuery.setInt(1, purchaseId);
            preQuery.setString(2, product.getName());
            preQuery.setInt(3, product.getPrice());
            preQuery.setString(4, product.getImagePath());
            preQuery.setInt(5, product.getQuantity());
            preQuery.setString(6, product.getColor());
            preQuery.setString(7, product.getBrand());
            
            if (preQuery.executeUpdate() > 0){
                isSuccesfully = true;
            }
            
        } catch(SQLException ex){
            isSuccesfully = false;
        }
        return isSuccesfully;
    }
    
    /**
     * 
     * @param purchaseId
     * @return todos los productos relacionados a un compra
     */
    public ArrayList<Product> getAllByPurchaseId(int purchaseId) {
        try {
            products.clear();
            preQuery = connection.prepareStatement(QUERIES[1]);
            preQuery.setInt(1, purchaseId);
            ResultSet data = preQuery.executeQuery();

            while (data.next()) {
                Product p = new Product(data.getString("name"),
                        data.getInt("price"),
                        data.getString("image_path"));
                p.setQuantity(data.getInt("quantity"));
                p.setColor(data.getString("color"));
                p.setBrand(data.getString("brand"));
                products.add(p);
            }

        } catch (SQLException ex) {
            products.clear();
        }
        return products;
    }
    
}
