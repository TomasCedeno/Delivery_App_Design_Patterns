
package logic.authenticator;

import db.DBFacade;
import logic.account.User;

public class SingUp extends Authenticator{
    private String identification, name, lastName, birthDay, address;
    private DBFacade db;

    public SingUp(String identification, String name, String lastName, String birthDay, String address) {
        db = new DBFacade();
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.address = address;
    }
    
    @Override
    public User auth(String email, String password) {
        User user = new User(email, password);
        user.setIdentification(identification);
        user.setName(name);
        user.setLastName(lastName);
        user.setBirthDay(birthDay);
        user.setAddress(address);

        return db.signUp(user) ? user : null;
    }
    
}
