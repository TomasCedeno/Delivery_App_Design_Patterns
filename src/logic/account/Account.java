
package logic.account;

public class Account implements AbstractAccount {      
    private int id, points, cost;
    String userId;
    private boolean discount, extraPoints, freeDelivery;
    private PaymentMethod paymentMethod;
    
    public Account() { points = 0; }
    
    @Override
    public String pay(int cost) {
        this.cost = cost;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public boolean isExtraPoints() {
        return extraPoints;
    }

    public void setExtraPoints(boolean extraPoints) {
        this.extraPoints = extraPoints;
    }

    public boolean isFreeDelivery() {
        return freeDelivery;
    }

    public void setFreeDelivery(boolean freeDelivery) {
        this.freeDelivery = freeDelivery;
    }
    
    public String getDetail(){
        String detail = "";
        detail += isDiscount()?"* Descuentos\n":"";
        detail += isExtraPoints()?"* Puntos Extra\n":"";
        detail += isFreeDelivery()?"* Entregas Gratis\n":"";
        return detail;
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

    @Override
    public int getCost() {
        return this.cost;
    }
}
