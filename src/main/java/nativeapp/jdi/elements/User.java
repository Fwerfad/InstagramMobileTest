package nativeapp.jdi.elements;

public class User {
    public String password;
    public String email;

    public static User defaultUser = new User("Fwerfadd", "12345678q");

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
