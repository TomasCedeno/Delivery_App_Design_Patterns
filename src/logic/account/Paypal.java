
package logic.account;

import Launcher.In;

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
        if(!In.read("Correo electrónico de la cuenta: ").equals(this.email) ||  
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
