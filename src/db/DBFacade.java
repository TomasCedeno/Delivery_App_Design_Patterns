package db;

import java.util.ArrayList;
import logic.account.Account;
import logic.account.User;
import logic.product.Product;
import logic.product.Purchase;


public class DBFacade {
    
    private AccountDAO accountDAO;
    private UserDAO userDAO;
    private ProductDAO productDAO;
    private PurchaseDAO purchaseDAO;

    public DBFacade() {
        this.accountDAO = new AccountDAO();
        this.userDAO = new UserDAO();
        this.productDAO = new ProductDAO();
        this.purchaseDAO = new PurchaseDAO();
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
    
    /**
     * 
     * @return todos los productos existentes en la base de datos
     */
    public ArrayList<Product> getProducts() {
        return productDAO.getAll();
    }
    
    /**
     * 
     * @param userId
     * @return el objeto del usuario asociado con el id pasado por parametro
     */
    public User getUser(String userId){
        return userDAO.getByIdentification(userId);
    }
    
    public boolean createPurchase(Purchase purchase){
        boolean created = purchaseDAO.create(purchase);
        
        purchase.getProducts().forEach(product -> {
            purchaseDAO.addProduct(purchase.getId(), product.getId());
        });
        
        return created;
    }
    
    /**
     * 
     * @param accountId
     * @return todas las compras realizadas por la cuenta con id pasado por parametro
     */
    public ArrayList<Purchase> getPurchasesByAccount(int accountId) {
        ArrayList<Purchase> purchases = purchaseDAO.getAllByAccountId(accountId);
        
        purchases.forEach(purchase -> {
            ArrayList<Integer> productsIds = purchaseDAO.getProductsIdByPurchase(purchase.getId());
            productsIds.forEach(id -> {
                purchase.getProducts().add(productDAO.getById(id));
            });
        });
        
        return purchases;
    }
    
}
