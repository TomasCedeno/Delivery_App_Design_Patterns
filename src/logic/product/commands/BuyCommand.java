
package logic.product.commands;

import db.DBFacade;
import logic.account.*;
import logic.product.*;

public class BuyCommand implements DataSender{
    private Purchase receiver;
    private AbstractAccount account;
    
    public BuyCommand(Purchase receiver, AbstractAccount acount){
        this.receiver = receiver;
        this.account = acount;
    }

    @Override
    public String sendData(Orderable p, String userId) {
        DBFacade db = new DBFacade();
        Account userAccount = (Account) db.getUser(userId).getAccount();
        
        String message = account.pay(p.getPrice());
        if(!message.equals("Datos incorrectos.")) {
            try{
                receiver.addProduct((Product) p);
            }catch(Exception e){
                receiver.setProducts(((Cart) p).getProducts());
            }
        }
            
        userAccount.setPoints(account.getPoints());
        db.updateAccount(userAccount);
            
        
        receiver.setPaymentMethod(account.getPaymentMethod().getName());
        receiver.setTotalPrice(account.getCost());
        db.createPurchase(receiver);
        
        return message;
    }
}
