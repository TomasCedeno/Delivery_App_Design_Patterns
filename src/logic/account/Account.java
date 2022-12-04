
package logic.account;

public class Account implements AbstractAccount {      
    private int points;
    private PaymentMethod paymentMethod;
    
    public Account() { points = 0; }
    
    @Override
    public String pay(int cost) {
        String answer = paymentMethod.pay(cost);
        if(!answer.equals("Datos incorrectos o cuenta no encontrada.")){
            points += 5;
        }
        
        return answer;
    }

    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    @Override
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
