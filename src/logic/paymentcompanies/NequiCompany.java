
package logic.paymentcompanies;

public class NequiCompany {
    public static boolean registPay(String accountNum, int cost){
        return (cost > 0 && accountNum.length() == 10);
    }
    
    public static boolean verifyNequiAccount(String accountNum, String password){
        // Aca se supone que la compañía Nequi debe verificar la existencia del usuario para que este pueda realizar el pago
        // Como esta parte está fuera de la lógica de la aplicación, asumimos que el usuario si existe
        
        return true;
    }
}
