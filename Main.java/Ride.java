
public class Ride implements Payable {

    // Ride properties
    private Rider rider;
    private Driver driver;
    private Vehicle vehicle;

    private Location pickup;
    private Location destination;

    private double distance;
    private double fare;

    private String status;
    private PaymentMode paymentMode;
    private String paymentStatus = "PENDING";

    public double getFare() {
        return fare;
    }

    public void completeRide() {
        if (status.equals("COMPLETED")) {
            System.out.println("Ride is already completed!");
        } else {
            status = "COMPLETED";
            System.out.println("Ride completed successfully!");
        }
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    // Constructor
    public Ride(Rider rider, Driver driver, Vehicle vehicle,
                Location pickup, Location destination) {

        this.rider = rider;
        this.driver = driver;
        this.vehicle = vehicle;

        this.pickup = pickup;
        this.destination = destination;

        this.status = "BOOKED";
    }

    // Calculate distance
    public double calculateDistance() {

        distance = pickup.calculateDistance(destination);

        return distance;
    }

    // Calculate fare
    public double calculateFare() {

        fare = vehicle.calculateFare(distance);

        return fare;
    }

    // Display ride information
    public void displayRideDetails() {

        System.out.println("\n===== RIDE DETAILS =====");

        System.out.println("Rider: " + rider.getName());
        System.out.println("Driver: " + driver.getName());

        System.out.printf("Distance: %.2f km%n", distance);


        System.out.println("Vehicle: " + vehicle.getClass().getSimpleName());

        
        System.out.printf("Fare: Rs. %.2f%n", fare);

        System.out.println("Status: " + status);
        System.out.println("Payment Method: " + paymentMode);
        System.out.println("Payment Status: " + paymentStatus);
    }
    public String getStatus() {
        return status;
    }

    @Override
    public void makePayment(double amount, PaymentMode mode) {

        if (amount <= 0) {
            System.out.println("Invalid payment amount!");
            return;
        }
        if (!status.equals("COMPLETED")) {
    System.out.println("Please complete the ride before payment!");
    return;
}

        if (paymentStatus.equals("PAID")) {
            System.out.println("Payment has already been completed!");
            return;
        }

        paymentMode = mode;
        paymentStatus = "PAID";

        System.out.println("\n===== PAYMENT DETAILS =====");
        System.out.println("Payment Method: " + paymentMode);
        System.out.printf("Amount Paid: Rs. %.2f%n", amount);
        System.out.println("Payment Status: " + paymentStatus);
        System.out.println("Payment Successful!");
        System.out.println("Pickup: " + pickup.getPlaceName());
        System.out.println("Destination: " + destination.getPlaceName());
    }
}
