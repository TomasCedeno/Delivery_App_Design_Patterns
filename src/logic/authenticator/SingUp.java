
package logic.authenticator;

import logic.account.User;

public class SingUp extends Authenticator{

    @Override
    public User auth(String email, String password) {
        // Se crea un usuario con los nuevos datos
        // Se crea y se hace vidible la interfáz de inicio
        
        return new User(email, password);
    }
    
}
