
package logic.account;

import logic.paymentcompanies.NequiCompany;

public class Nequi implements PaymentMethod {
    
    private String name;
    private String accountNum;
    private String password;

    public Nequi(String accountNum, String password) {
        this.accountNum = accountNum;
        this.password = password;
        this.name = "Nequi";
    }
    
    @Override
    public String pay(int cost) {
        if(NequiCompany.verifyNequiAccount(accountNum, password)){
            if(NequiCompany.registPay(accountNum, cost)) return "Pago exitoso de $"+cost+" pesos.";
        }
        
        return "Datos incorrectos.";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
