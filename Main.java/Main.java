
import java.util.Scanner;

public class Main {

    // Location selection method
    private static Location getLocation(Scanner scanner, String type) {

        System.out.println("\n===== " + type + " LOCATION =====");
        System.out.println("1. University of Sindh");
        System.out.println("2. Autobahn Road");
        System.out.println("3. Qasimabad");
        System.out.println("4. Latifabad");
        System.out.println("5. Hyderabad Railway Station");
        System.out.println("6. Enter Custom Location");

        System.out.print("Select Location: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {

            case 1:
                return new Location("University of Sindh");

            case 2:
                return new Location("Autobahn Road");

            case 3:
                return new Location("Qasimabad");

            case 4:
                return new Location("Latifabad");

            case 5:
                return new Location("Hyderabad Railway Station");

            case 6:

                System.out.print("Enter Location Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Latitude: ");
                double latitude = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter Longitude: ");
                double longitude = Double.parseDouble(scanner.nextLine());

                return new Location(name, latitude, longitude);

            default:
                throw new IllegalArgumentException(
                    "Invalid location selection!"
                );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Rider rider = null;
        Ride ride = null;
        Rating rating = null;

        // Available drivers
        Driver bikeDriver = new Driver(
            201, "Zamrad", "0301234567", "DL12345", true
        );

        Driver carDriver = new Driver(
            202, "Zain", "0307654321", "DL12346", true
        );

        Driver rickshawDriver = new Driver(
            203, "Khan", "0312345678", "DL12347", true
        );

        Driver driver = null;

        int choice;

        do {

            System.out.println("\n===== SMART RIDE BOOKING SYSTEM =====");
            System.out.println("1. Register Rider");
            System.out.println("2. View Vehicles");
            System.out.println("3. View Available Drivers");
            System.out.println("4. Book a Ride");
            System.out.println("5. View Ride Details");
            System.out.println("6. Complete Ride");
            System.out.println("7. Make Payment");
            System.out.println("8. Give Driver Rating");
            System.out.println("9. Exit");

            System.out.print("\nEnter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                // 1. Register Rider
                case 1:

                    System.out.println("\n===== RIDER REGISTRATION =====");

                    System.out.print("Enter Rider Name: ");
                    String riderName = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String riderPhone = scanner.nextLine();

                    rider = new Rider(riderName, riderPhone);

                    System.out.println("\nRider registered successfully!");
                    rider.displayDetails();

                    break;

                // 2. View Vehicles
                case 2:

                    System.out.println("\n===== AVAILABLE VEHICLES =====");

                    Bike bike = new Bike();
                    Car car = new Car();
                    Rickshaw rickshaw = new Rickshaw();

                    System.out.println("1. Bike");
                    System.out.printf(
                        "   Fare for 10 km: Rs. %.2f%n",
                        bike.calculateFare(10)
                    );

                    System.out.println("2. Car");
                    System.out.printf(
                        "   Fare for 10 km: Rs. %.2f%n",
                        car.calculateFare(10)
                    );

                    System.out.println("3. Rickshaw");
                    System.out.printf(
                        "   Fare for 10 km: Rs. %.2f%n",
                        rickshaw.calculateFare(10)
                    );

                    break;

                // 3. View Available Drivers
                case 3:

                    System.out.println("\n===== AVAILABLE DRIVERS =====");

                    bikeDriver.displayDetails();
                    System.out.println();

                    carDriver.displayDetails();
                    System.out.println();

                    rickshawDriver.displayDetails();

                    break;

                // 4. Book a Ride
                case 4:

                    if (rider == null) {
                        System.out.println(
                            "Please register as a rider first!"
                        );
                        break;
                    }

                    System.out.println("\n===== BOOK A RIDE =====");

                    System.out.println("\nSelect Vehicle:");
                    System.out.println("1. Bike");
                    System.out.println("2. Car");
                    System.out.println("3. Rickshaw");

                    System.out.print("Enter your choice: ");
                    int vehicleChoice =
                        Integer.parseInt(scanner.nextLine());

                    Vehicle vehicle;

                    if (vehicleChoice == 1) {
                        vehicle = new Bike();
                        driver = bikeDriver;
                    }
                    else if (vehicleChoice == 2) {
                        vehicle = new Car();
                        driver = carDriver;
                    }
                    else if (vehicleChoice == 3) {
                        vehicle = new Rickshaw();
                        driver = rickshawDriver;
                    }
                    else {
                        System.out.println("Invalid vehicle choice!");
                        break;
                    }

                    try {

                        Location pickup =
                            getLocation(scanner, "PICKUP");

                        Location destination =
                            getLocation(scanner, "DESTINATION");

                        ride = new Ride(
                            rider,
                            driver,
                            vehicle,
                            pickup,
                            destination
                        );

                        ride.calculateDistance();
                        ride.calculateFare();

                        System.out.println("\nRide booked successfully!");

                        ride.displayRideDetails();

                    }
                    catch (IllegalArgumentException e) {

                        System.out.println(
                            "\nError: " + e.getMessage()
                        );

                    }

                    break;

                // 5. View Ride Details
                case 5:

                    if (ride == null) {
                        System.out.println("No ride has been booked yet!");
                    }
                    else {
                        System.out.println(
                            "\n===== VIEW RIDE DETAILS ====="
                        );

                        ride.displayRideDetails();
                    }

                    break;

                // 6. Complete Ride
                case 6:

                    if (ride == null) {
                        System.out.println("Please book a ride first!");
                    }
                    else {
                        ride.completeRide();
                    }

                    break;

                // 7. Make Payment
                case 7:

                    if (ride == null) {
                        System.out.println("Please book a ride first!");
                        break;
                    }

                    System.out.println("\n===== PAYMENT =====");
                    System.out.println("1. Cash");
                    System.out.println("2. Card");
                    System.out.println("3. Wallet");

                    System.out.print("Select Payment Method: ");
                    int paymentChoice =
                        Integer.parseInt(scanner.nextLine());

                    PaymentMode selectedMode;

                    if (paymentChoice == 1) {
                        selectedMode = PaymentMode.CASH;
                    }
                    else if (paymentChoice == 2) {
                        selectedMode = PaymentMode.CARD;
                    }
                    else if (paymentChoice == 3) {
                        selectedMode = PaymentMode.WALLET;
                    }
                    else {
                        System.out.println("Invalid payment method!");
                        break;
                    }

                    ride.makePayment(
                        ride.getFare(),
                        selectedMode
                    );

                    break;

                // 8. Give Driver Rating
                case 8:

                    if (ride == null) {
                        System.out.println("Please book a ride first!");
                        break;
                    }

                    if (!ride.getStatus().equals("COMPLETED")) {
                        System.out.println(
                            "Please complete the ride first!"
                        );
                        break;
                    }

                    if (!ride.getPaymentStatus().equals("PAID")) {
                        System.out.println(
                            "Please complete payment first!"
                        );
                        break;
                    }

                    System.out.println("\n===== RATE YOUR DRIVER =====");

                    System.out.print("Enter Stars (1-5): ");
                    int stars = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Feedback: ");
                    String feedback = scanner.nextLine();

                    try {

                        rating = new Rating(
                            driver,
                            stars,
                            feedback
                        );

                        rating.displayRating();

                    }
                    catch (IllegalArgumentException e) {

                        System.out.println(
                            "Error: " + e.getMessage()
                        );

                    }

                    break;

                // 9. Exit
                case 9:

                    System.out.println(
                        "\nThank you for using Smart Ride Booking System!"
                    );

                    break;

                default:

                    System.out.println("Invalid choice! Try again.");

            }

        } while (choice != 9);

        scanner.close();
    }
}
