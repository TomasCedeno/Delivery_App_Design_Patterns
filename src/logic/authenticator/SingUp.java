
package logic.authenticator;

import db.DBFacade;
import logic.account.User;
import test.In;

public class SingUp extends Authenticator{

    private DBFacade db = new DBFacade();
    
    @Override
    public User auth(String email, String password) {
        // Se crea un usuario con los nuevos datos
        User user = new User(email, password);
        user.setIdentification(In.read("Ingresa tu identifcación: "));
        user.setName(In.read("Ingresa tu nombre: "));
        user.setLastName(In.read("Ingresa tu apellido: "));
        user.setBirthDay(In.read("Ingresa tu fecha de nacimiento: "));
        user.setAddress(In.read("Ingresa tu dirección:: "));

        return db.signUp(user) ? user : null;
    }
    
}
