
public class Location {

    private String placeName;
    private double latitude;
    private double longitude;

    // Constructor for predefined locations
    public Location(String placeName) {

        this.placeName = placeName;

        switch (placeName.toLowerCase()) {

            case "university of sindh":
                latitude = 25.4300;
                longitude = 68.2800;
                break;

            case "autobahn road":
                latitude = 25.3960;
                longitude = 68.3578;
                break;

            case "qasimabad":
                latitude = 25.4080;
                longitude = 68.3450;
                break;

            case "latifabad":
                latitude = 25.3850;
                longitude = 68.3300;
                break;

            case "hyderabad railway station":
                latitude = 25.3800;
                longitude = 68.3650;
                break;

            default:
                throw new IllegalArgumentException(
                    "Predefined location not found!"
                );
        }
    }

    // Constructor for custom locations
    public Location(String placeName, double latitude, double longitude) {

        if (latitude < -90 || latitude > 90 ||
            longitude < -180 || longitude > 180) {

            throw new IllegalArgumentException(
                "Invalid latitude or longitude!"
            );
        }

        this.placeName = placeName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getPlaceName() {
        return placeName;
    }

    // Calculate distance using Haversine formula
    public double calculateDistance(Location destination) {

        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);

        double lat2 = Math.toRadians(destination.latitude);
        double lon2 = Math.toRadians(destination.longitude);

        double deltaLat = lat2 - lat1;
        double deltaLon = lon2 - lon1;

        double a = Math.pow(Math.sin(deltaLat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(deltaLon / 2), 2);

        double c = 2 * Math.atan2(
            Math.sqrt(a), Math.sqrt(1 - a)
        );

        return 6371 * c;
    }
}
