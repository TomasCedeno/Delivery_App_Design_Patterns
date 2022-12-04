
package logic.account;

public class User {
    private String name, lastName, birthDay, identification, address;
    private AbstractAccount account;

    public User(String name, String lastName, String birthDay, String identification, String address) {
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.identification = identification;
        this.address = address;
        this.account = new Account();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AbstractAccount getAccount() {
        return account;
    }

    public void setAccount(AbstractAccount account) {
        this.account = account;
    }
}
