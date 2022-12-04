
package logic.account;

public class Discount extends Benefits {
    public Discount(AbstractAccount account) {
        super(account);
    }

    @Override
    public String pay(int cost) {      
        cost -= cost * 0.1f;
        String answer = account.pay(cost);
        
        if(!answer.equals("Datos incorrectos.")){
            return answer + " Con descuento del 10%.";
        }
        
        return answer;
    }
}
