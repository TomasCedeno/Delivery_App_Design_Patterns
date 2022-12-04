
package logic.authenticator;

import logic.account.User;

public class Login extends Authenticator {

    @Override
    public User auth(String email, String password) {
        // Se cargan los datos del usuario ya existente
        // Se crea y se hace vidible la interfáz de inicio
        
        User usuarioExistente = new User(email, password);
        usuarioExistente.getAccount().setPoints(16);
        
        return usuarioExistente;
    }
    
}
