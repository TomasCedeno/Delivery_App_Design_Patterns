
package test;

import logic.account.*;

public class Prueba {
    public static void main(String[] args) {
        User user = new User("Pepito","Perez","03/12/2022","111","Al fondo a la derecha");
        
        AbstractAccount a = user.getAccount();
        
        a.setPaymentMethod(new Nequi("123","123"));
        Out.show(a.pay(15000));
        
        AbstractAccount aD = new Discount(a);
        Out.show(aD.pay(15000));
        
        AbstractAccount aFD = new FreeDelivery(a);
        Out.show(aFD.pay(15000));
        
        AbstractAccount aEP = new ExtraPoints(a);
        Out.show(aEP.pay(15000));
        Out.show(""+aEP.getPoints());
        
        AbstractAccount aFDEP = new ExtraPoints(aFD);
        Out.show(aFDEP.pay(15000));
        Out.show(""+aFDEP.getPoints());
    }
}
