
package logic.account;

import Launcher.In; 

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
        if(!In.read("Número de cuenta: ").equals(this.accountNum) || 
                !In.read("Fecha de caducidad: ").equals(this.expirationDate) || 
                !In.read("Contraseña: ").equals(this.password) || 
                !In.read("CCV: ").equals(this.ccv)){
            return "Datos incorrectos.";
        }
        
        return "Pago exitoso de $"+cost+" pesos.";
    }
    
    @Override
    public String getName() {
        return this.name;
    }
}
