
package logic.authenticator;
        
import logic.account.User;

public class VerificationSing extends Authenticator{
    
    @Override
    public User auth(String email, String password) {  
        // Verifica que NO existan usuarios con el email especificados
        if(email.equals("email")) { return null; }
        else { setNext(new SingUp()); }
               
        return next.auth(email, password);
    }
}
