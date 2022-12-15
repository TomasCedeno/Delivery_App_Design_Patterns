
package logic.product.commands;

import db.DBFacade;
import logic.account.*;
import logic.product.*;
import Launcher.In;
import Launcher.Out;

public class BuyCommand implements DataSender{
    private Purchase receiver;
    private AbstractAccount account;
    
    public BuyCommand(Purchase receiver){
        this.receiver = receiver;
    }

    @Override
    public void sendData(Orderable p, String userId) {
        DBFacade db = new DBFacade();
        account = db.getAccountWithBenefits(userId);
        Account userAccount = (Account) db.getUser(userId).getAccount();
        
        if(account.getPaymentMethod() == null) account.setPaymentMethod(setNewPaymentMethod());
        
        if(In.read("¿Desea cambiar su método de pago?\n1) Si\n2) No").equals("1")){
            account.setPaymentMethod(setNewPaymentMethod());
        } else{
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
            Out.show(message);
        }
        
        receiver.setPaymentMethod(account.getPaymentMethod().getName());
        receiver.setTotalPrice(account.getCost());
        db.createPurchase(receiver);
    }
    
    private PaymentMethod setNewPaymentMethod(){
        PaymentMethod newPaymentMethod = null;
        String option = In.read("¿Qué método de pago desea agregar?\n1) Tarjeta de crédito\n2) Nequi\n3) Paypal");
        
        switch(option){
            case "1": 
                newPaymentMethod = new CreditCard(
                        In.read("Número de cuenta: "), 
                        In.read("Contraseña: "), 
                        In.read("CCV: "), 
                        In.read("Fecha de expiración: "));
                break;
            case "2":
                newPaymentMethod = new Nequi(
                        In.read("Número de cuenta: "), 
                        In.read("Contraseña: "));
                break;
            case "3":
                newPaymentMethod = new Paypal(
                        In.read("E-mail de la cuenta: "), 
                        In.read("Contraseña: "));
                break;
            default: Out.show(option + " no está entre las opciones."); break;
        }
        
        return newPaymentMethod;
    }
}
