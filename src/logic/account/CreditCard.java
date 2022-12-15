
package logic.account;

import logic.paymentcompanies.Bank;

public class CreditCard implements PaymentMethod {
    
    private String name;
    private String accountNum;
    private String password;
    private String ccv;
    private String expirationDate;

    public CreditCard(String accountNum, String password, String ccv, String expirationDate) {
        this.accountNum = accountNum;
        this.password = password;
        this.ccv = ccv;
        this.expirationDate = expirationDate;
        this.name = "Tarjeta de Crédito";
    }

    @Override
    public String pay(int cost) {
        if(Bank.verifyCreditCard(accountNum, ccv, password)){
            if(Bank.registPay(accountNum, cost)) return "Pago exitoso de $"+cost+" pesos.";
        }
        
        return "Datos incorrectos.";
    }
    
    @Override
    public String getName() {
        return this.name;
    }
}
