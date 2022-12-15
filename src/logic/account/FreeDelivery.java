
package logic.account;

public class FreeDelivery extends Benefits {
    public FreeDelivery(AbstractAccount account) {
        super(account);
    }

    @Override
    public String pay(int cost) {
        cost -= 5000;  
        String answer = account.pay(cost);
        
        if(!answer.equals("Datos incorrectos.")){
            return answer + " Con envio gratis.";
        }
        
        return answer;
    }
    
    @Override
    public int getCost() {
        return this.account.getCost();
    }
}
