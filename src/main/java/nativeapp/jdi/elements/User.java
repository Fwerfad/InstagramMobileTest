package nativeapp.jdi.elements;

public class User {
    public String email;
    public String password;

    public static User defaultUser = new User("", "");

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
