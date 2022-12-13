package test;

import db.DBFacade;
import java.util.ArrayList;
import logic.account.Account;
import logic.account.User;
import logic.product.Product;
import logic.product.Purchase;

public class DBTestDrive {
    
    
    public static void main(String[] args) {
        
        DBFacade db = new DBFacade();
        
        //Registro
        User user = new User("user@email.com", "123");
        user.setIdentification("1234");
        System.out.println( db.signUp(user)?"Se creo el usuario":"NO se creo el usuario" );
        
        //Inico de Sesion
        System.out.println( db.logIn(user.getEmail(), "000")?"Se inicio sesion":"NO se inicio sesion" );
        System.out.println( db.logIn(user.getEmail(), "123")?"Se inicio sesion":"NO se inicio sesion" );

        
        //Compras
        Account account = (Account) db.getUser("1234").getAccount();
        ArrayList<Product> products = new ArrayList();
        
        Product pc = new Product("Computador portatil", 1700000, "./src/Resources/PC.jpg");
        pc.setQuantity(2);
        pc.setColor("verde");
        pc.setBrand("Gucci");
        
        Product phone = new Product("Celular", 800000, "./src/Resources/Cellphone.jfif");
        phone.setQuantity(5);
        phone.setColor("naranja");
        phone.setBrand("Mc Donalds");
        
        products.add(pc);
        products.add(phone);
        Purchase purchase = new Purchase(9000, account.getId(), "En especie", products, 0);
        db.createPurchase(purchase);
        
        ArrayList<Purchase> purchases = db.getPurchasesByAccount(account.getId());
        purchases.forEach(p -> {
            System.out.println(String.format("\n"
                    + "\nid compra: %d"
                    + "\nid cuenta: %d"
                    + "\nmetodo de pago: %s"
                    + "\nvalor total: %d", p.getId(), p.getAccountId(), p.getPaymentMethod(), p.getTotalPrice()));
            p.getProducts().forEach(product -> System.out.println(product.getDetail()));
        });
         
    }
    
}
