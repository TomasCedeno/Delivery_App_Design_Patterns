
package logic.paymentcompanies;

public class PaypalCompany {
    public static boolean registPay(String email, int cost){
        return (cost > 0 && email.contains("@"));
    }
    
    public static boolean verifyPaypalAccount(String email, String password){
        // Aca se supone que la compañía Paypal debe verificar la existencia del usuario para que este pueda realizar el pago
        // Como esta parte está fuera de la lógica de la aplicación, asumimos que el usuario si existe
        
        return true;
    }
}
