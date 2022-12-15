
package logic.account;

import logic.paymentcompanies.PaypalCompany;

public class Paypal implements PaymentMethod {
    
    private String name;
    private String email;
    private String password;

    public Paypal(String email, String password) {
        this.email = email;
        this.password = password;
        this.name = "Paypal";
    }
    
    @Override
    public String pay(int cost) {
        if(PaypalCompany.verifyPaypalAccount(email, password)){
            if(PaypalCompany.registPay(email, cost)) return "Pago exitoso de $"+cost+" pesos.";
        }
        
        return "Datos incorrectos.";
    }
    
    @Override
    public String getName() {
        return this.name;
    }
}
