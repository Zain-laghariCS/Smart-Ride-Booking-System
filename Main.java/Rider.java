
public class Rider extends User {

    private static int nextRiderId = 101;

    public Rider(String name, String phone) {
        super(nextRiderId++, name, phone);
    }

    public void bookRide() {
        System.out.println(name + " is booking a ride...");
    }

    @Override
    public void displayDetails() {
        System.out.println("Rider ID: " + userId);
        System.out.println("Rider Name: " + name);
        System.out.println("Phone: " + phone);
    }
}
