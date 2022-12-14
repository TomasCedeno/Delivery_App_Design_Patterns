
package logic.account;

import test.In;

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
        if(!In.read("Número de cuenta: ").equals(this.accountNum) ||  
                !In.read("Contraseña: ").equals(this.password)){
            return "Datos incorrectos.";
        }
        
        return "Pago exitoso de $"+cost+" pesos.";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
