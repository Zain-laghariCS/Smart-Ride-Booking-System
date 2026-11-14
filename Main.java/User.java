
public abstract class User {

    // Properties (data)
    protected int userId;
    protected String name;
    protected String phone;

    // Constructor
    public User(int userId, String name, String phone) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
    }

    // Common method
    public void login() {
        System.out.println(name + " logged in successfully!");
    }

    // Abstract method
    public abstract void displayDetails();
    public String getName() {
    return name;
}
}
