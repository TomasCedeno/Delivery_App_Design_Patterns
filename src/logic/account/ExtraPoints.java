
package logic.account;

public class ExtraPoints extends Benefits {
    public ExtraPoints(AbstractAccount account) {
        super(account);
    }

    @Override
    public String pay(int cost) {  
        String answer = account.pay(cost);
        
        if(!answer.equals("Datos incorrectos.")){
            account.setPoints(account.getPoints() + 5);
            return answer + " Y ganas el doble de puntos.";
        }
        
        return answer;
    }
    
    @Override
    public int getCost() {
        return this.account.getCost();
    }
}
