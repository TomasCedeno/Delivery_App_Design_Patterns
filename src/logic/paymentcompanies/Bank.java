
package logic.paymentcompanies;

public class Bank {
    public static boolean registPay(String accountNum, int cost){
        return (cost > 0 && accountNum.replace(" ", "").length() == 16);
    }
    
    public static boolean verifyCreditCard(String accountNum, String ccv, String password){
        // Aca se supone que la compañía Paypal debe verificar la existencia del usuario para que este pueda realizar el pago
        // Como esta parte está fuera de la lógica de la aplicación, asumimos que el usuario si existe
        
        return true;
    }
}
