
package logic.account;

public interface AbstractAccount {    
    public String pay(int cost);
    public int getPoints();
    public void setPoints(int points);
    public PaymentMethod getPaymentMethod();
    public void setPaymentMethod(PaymentMethod paymentMethod);
    public int getCost();
}
