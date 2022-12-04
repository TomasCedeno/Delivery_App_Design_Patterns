
package logic.account;

public class FreeDelivery extends Benefits {
    public FreeDelivery(AbstractAccount account) {
        super(account);
    }

    @Override
    public String pay(int cost) {
        cost -= 2000;  
        String answer = account.pay(cost);
        
        if(!answer.equals("Datos incorrectos.")){
            return answer + " Con envio gratis.";
        }
        
        return answer;
    }
}
