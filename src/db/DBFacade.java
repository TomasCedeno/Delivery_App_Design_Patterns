package db;

import java.util.ArrayList;
import logic.account.*;
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
     * @return el objeto usuario si la contraseña es correcta, null caso contrario
     */
    public User logIn(String email, String password){
        User user = userDAO.getByEmail(email);
        if ( user.getPassword().equals(password) ) {
            return user;
        }
    
        return null;
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
     * Actualiza la contraseña y direccion de un usuario en la base de datos
     * @param user el usuario con los nuevos datos 
     * @return true si se actualizo con exito
     */
    public boolean updateUser(User user) {
        return userDAO.update(user);
    }
    
    /**
     * Retorna la cuenta con los beneficos asociada al usuario con id pasado por parametro
     * @param userId el id del usuario al que pertenece la cuenta
     * @return la cuenta con sus beneficios (decoradores agregados)
     */
    public AbstractAccount getAccountWithBenefits(String userId) {
        Account account = accountDAO.getByUserId(userId);
        AbstractAccount benefits = account;
        
        if (account.isDiscount()) {
            benefits = new Discount(benefits);
            
        } if (account.isExtraPoints()) {
            benefits = new ExtraPoints(benefits);
            
        } if (account.isFreeDelivery()) {
            benefits = new FreeDelivery(benefits);
        }
        
        return benefits;
    }
    
    /**
     * Actualiza los puntos y beneficios de la cuenta
     * @param account
     * @return true si se actualizo con exito
     */
    public boolean updateAccount(Account account) {
        return accountDAO.update(account);
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
