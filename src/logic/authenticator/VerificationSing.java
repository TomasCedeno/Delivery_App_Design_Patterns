
package logic.authenticator;
        
import db.DBFacade;
import logic.account.User;

public class VerificationSing extends Authenticator{
    
    DBFacade db = new DBFacade();
    
    @Override
    public User auth(String email, String password) {  
        // Verifica que NO existan usuarios con el email especificados
        if(db.userExists(email)) { return null; }
               
        return next.auth(email, password);
    }
}
