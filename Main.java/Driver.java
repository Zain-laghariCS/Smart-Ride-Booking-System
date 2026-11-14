
public class Driver extends User {

    // Driver's additional properties
    private String licenseNumber;
    private boolean available;

    // Constructor
    public Driver(int userId, String name, String phone,
                  String licenseNumber, boolean available) {

        super(userId, name, phone);

        this.licenseNumber = licenseNumber;
        this.available = available;
    }

    // Driver's own method
    public void acceptRide() {
        if (available) {
            System.out.println(name + " accepted the ride!");
            available = false;
        } else {
            System.out.println(name + " is not available.");
        }
    }

    // Implementing abstract method
    @Override
    public void displayDetails() {
        System.out.println("Driver ID: " + userId);
        System.out.println("Driver Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("License: " + licenseNumber);
        System.out.println("Available: " + available);
    }
}
