
package logic.account;

public class Account implements AbstractAccount {      
    private int id, points;
    private PaymentMethod paymentMethod;
    
    public Account() { points = 0; }
    
    @Override
    public String pay(int cost) {
        String answer = paymentMethod.pay(cost);
        if(!answer.equals("Datos incorrectos.")){
            points += 5;
        }
        
        return answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
