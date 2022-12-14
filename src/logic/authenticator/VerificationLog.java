
package logic.authenticator;

import logic.account.User;
import db.DBFacade;

public class VerificationLog extends Authenticator {
    
    private DBFacade db = new DBFacade();
    
    @Override
    public User auth(String email, String password) { 
        // Verifica que exista un usuario con el email pasado
        if (db.userExists(email)){
            return next.auth(email, password);
        }
               
        return null;
    }
    
}
