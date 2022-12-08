package db;

import java.util.ArrayList;
import logic.account.Account;
import logic.account.User;
import logic.product.Product;


public class DBFacade {
    
    private AccountDAO accountDAO;
    private UserDAO userDAO;
    private ProductDAO productDAO;

    public DBFacade() {
        this.accountDAO = new AccountDAO();
        this.userDAO = new UserDAO();
        this.productDAO = new ProductDAO();
    }
    
    /**
     * 
     * @param email
     * @return true si el usuario con el email pasado existe, caso contrario false
     */
    public boolean userExists(String email){
        User user = userDAO.getByEmail(email);
        return user != null;
    }
    
    /**
     * 
     * @param user
     * @return true si se creo el usuario, false caso contrario
     */
    public boolean signUp(User user) {
        Account account = new Account();
        account.setUserId(user.getIdentification());
        user.setAccount(account);
        return accountDAO.create(account) && userDAO.create(user);
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return true si la contraseña es correcta
     */
    public boolean logIn(String email, String password){
        User user = userDAO.getByEmail(email);
        return user.getPassword().equals(password);
    }
    
    public ArrayList<Product> getProducts() {
        return productDAO.getAll();
    }
    
    public User getUser(String userId){
        return userDAO.getByIdentification(userId);
    }
}
