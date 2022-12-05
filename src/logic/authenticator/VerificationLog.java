
package logic.authenticator;

import logic.account.User;

public class VerificationLog extends Authenticator {

    @Override
    public User auth(String email, String password) { 
        // Verifica que existan usuarios con el email y password especificados
        if(email.equals("email") && password.equals("password")) { return next.auth(email, password); }
               
        return null;
    }
    
}
