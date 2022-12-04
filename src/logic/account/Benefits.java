
package logic.account;

public abstract class Benefits implements AbstractAccount {
    protected AbstractAccount account;
    
    public Benefits(AbstractAccount account) {
        super();
        this.account = account;
    }

    @Override
    public abstract String pay(int cost);
    
    @Override
    public int getPoints() {
        return this.account.getPoints();
    }

    @Override
    public void setPoints(int points) {
        this.account.setPoints(points);
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return this.account.getPaymentMethod();
    }

    @Override
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.account.setPaymentMethod(paymentMethod);
    }
}
