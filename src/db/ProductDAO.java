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
    private Product product;
    private ArrayList<Product> products;
    
    private final String[] QUERIES = {
        "SELECT * FROM product",
        "INSERT INTO product (id, name, price, quantity, image_path, description, color, brand) VALUES (?,?,?,?,?,?,?,?);",
        "SELECT id, name, price, quantity, image_path, description, color, brand FROM product WHERE name = ? AND color = ? AND brand = ?;"
    };

    public ProductDAO() {
        connection = DBConnection.getInstance().getConnection();
        products = new ArrayList();
    }
    
    public ArrayList<Product> getAll() {
        try {
            products.clear();
            preQuery = connection.prepareStatement(QUERIES[0]);
            ResultSet data = preQuery.executeQuery();

            while (data.next()) {
                product = new Product(
                        data.getInt("id"),
                        data.getString("name"),
                        data.getDouble("price"),
                        data.getInt("quantity"),
                        data.getString("image_path"),
                        data.getString("description"));
                product.setColor(data.getString("color"));
                product.setBrand(data.getString("brand"));
                products.add(product);
            }

        } catch (SQLException ex) {
            products.clear();
        }
        return products;
    }
    
    public boolean create(Product product) {
        try {
            preQuery = connection.prepareStatement(QUERIES[1]);
            
            preQuery.setInt(1, product.getId());
            preQuery.setString(2, product.getName());
            preQuery.setDouble(3, product.getPrice());
            preQuery.setInt(4, product.getQuantity());
            preQuery.setString(5, product.getImagePath());
            preQuery.setString(6, product.getDescription());
            preQuery.setString(7, product.getColor());
            preQuery.setString(8, product.getBrand());
            
            if (preQuery.executeUpdate() > 0){
                isSuccesfully = true;
            }
            
        } catch(SQLException ex){
            isSuccesfully = false;
        }
        return isSuccesfully;
    }
    
    public Product getByNameColorBrand(String name, String color, String brand){
        try {
            preQuery = connection.prepareStatement(QUERIES[2]);

            preQuery.setString(1, name);
            preQuery.setString(2, color);
            preQuery.setString(3, brand);

            ResultSet data = preQuery.executeQuery();

            if (data.next()) {
                product.setId(data.getInt("id"));
                product.setName(data.getString("name"));
                product.setPrice(data.getDouble("price"));
                product.setQuantity(data.getInt("quantity"));
                product.setImagePath(data.getString("image_path"));
                product.setDescription(data.getString("idescription"));
                product.setColor(data.getString("color"));
                product.setBrand(data.getString("brand"));
            }

        } catch (SQLException ex) {
            product = null;
        }
        return product;
    }
    
    
}
