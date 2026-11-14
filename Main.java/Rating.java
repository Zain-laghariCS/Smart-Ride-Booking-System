public class Rating {

    private Driver driver;
    private int stars;
    private String feedback;

    public Rating(Driver driver, int stars, String feedback) {

    if (stars < 1 || stars > 5) {
        throw new IllegalArgumentException(
            "Rating must be between 1 and 5 stars!"
        );
    }

    this.driver = driver;
    this.stars = stars;
    this.feedback = feedback;
}
    

    public void displayRating() {

        System.out.println("\n===== DRIVER RATING =====");
        System.out.println("Driver: " + driver.getName());
        System.out.println("Stars: " + stars + "/5");
        System.out.println("Feedback: " + feedback);

    }
}