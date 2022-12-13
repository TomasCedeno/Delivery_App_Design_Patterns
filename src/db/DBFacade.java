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
        return userDAO.create(user) && accountDAO.create(account);
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
     * @param userId
     * @return el objeto del usuario asociado con el id pasado por parametro
     */
    public User getUser(String userId){
        User user = userDAO.getByIdentification(userId);
        user.setAccount(accountDAO.getByUserId(userId));
        return user;
    }
    
    /**
     * Registra una compra en la base de datos relacionando todos sus productos, ignorando el id
     * y asignandole uno nuevo por la base de datos como un consecutivo
     * @param purchase
     * @return true o false dependiendo del exito de la operacion
     */
    public boolean createPurchase(Purchase purchase){
        boolean created = purchaseDAO.create(purchase);
        int purchaseId = purchaseDAO.getAllByAccountId(purchase.getAccountId()).get(0).getId();

        purchase.getProducts().forEach(product -> {
            productDAO.create(product, purchaseId);
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
            purchase.getProducts().addAll(productDAO.getAllByPurchaseId(purchase.getId()));
        });
        
        return purchases;
    }
    
}
