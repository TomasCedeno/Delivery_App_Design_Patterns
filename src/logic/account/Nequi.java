
package logic.account;

import test.In; // Hay que reemplazar los In

public class Nequi implements PaymentMethod {
    
    private String accountNum;
    private String password;

    public Nequi(String accountNum, String password) {
        this.accountNum = accountNum;
        this.password = password;
    }
    
    @Override
    public String pay(int cost) {
        if(!In.read("Número de cuenta: ").equals(this.accountNum) ||  
                !In.read("Contraseña: ").equals(this.password)){
            return "Datos incorrectos o cuenta no encontrada.";
        }
        
        // Tal vez descuente saldo
        
        return "Pago exitoso de $"+cost+" pesos.";
    }
}
