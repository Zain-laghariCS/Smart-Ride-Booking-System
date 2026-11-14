
public abstract class Vehicle {

    protected double baseFare;
    protected double ratePerKm;

    // Parent constructor
    public Vehicle(double baseFare, double ratePerKm) {
        this.baseFare = baseFare;
        this.ratePerKm = ratePerKm;
    }

    // Abstract method
    public abstract double calculateFare(double distance);
}


// Child class 1
class Bike extends Vehicle {

    public Bike() {
        super(30, 15);
    }

    @Override
    public double calculateFare(double distance) {
        return baseFare + (ratePerKm * distance);
    }
}


// Child class 2
class Car extends Vehicle {

    public Car() {
        super(100, 35);
    }

    @Override
    public double calculateFare(double distance) {
        return baseFare + (ratePerKm * distance);
    }
}


// Child class 3
class Rickshaw extends Vehicle {

    public Rickshaw() {
        super(40, 20);
    }

    @Override
    public double calculateFare(double distance) {
        return baseFare + (ratePerKm * distance);
    }
}
