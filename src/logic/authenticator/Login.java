package logic.authenticator;

import db.DBFacade;
import logic.account.User;

public class Login extends Authenticator {

    private DBFacade db = new DBFacade();
    
    @Override
    public User auth(String email, String password) {
        return db.logIn(email, password);     
    }
    
}
