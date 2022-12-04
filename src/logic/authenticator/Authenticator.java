
package logic.authenticator;

import logic.account.User;

public abstract class Authenticator {
    protected Authenticator next;
    
    public abstract User auth(String email, String password);
    
    public void setNext(Authenticator next){
        this.next = next;
    }
}
