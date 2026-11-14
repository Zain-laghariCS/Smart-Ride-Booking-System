# Smart Ride Booking System
============================================
# Team Members Name#:
**1. Zamin Ali S/O Muhammad Ashraf Laghari**
**2. Gulzar Ahmed S/O Jani Khan**
# Roll No # :
2k26/CSM/136
2k26/CSM/34
===============================================
## Project Overview
The Smart Ride Booking System is a console-based Java application inspired by ride-booking services such as Careem and Uber.

It allows riders to register, select vehicles, book rides, calculate fares, make payments, and rate drivers.

## Features
- Rider registration with automatic Rider ID generation
- Multiple vehicle types: Bike, Car, and Rickshaw
- Driver information display
- Predefined pickup and destination locations
- Custom locations using latitude and longitude
- Distance calculation using the Haversine formula
- Automatic fare calculation based on vehicle type and distance
- Ride booking and completion
- Payment options: Cash, Card, and Wallet
- Driver rating and feedback
- Input validation for ratings and coordinates

## Technologies Used
- Java
- Object-Oriented Programming (OOP)
- Java Scanner for user input
- VS Code
- JDK 21

## OOP Concepts Demonstrated
- **Encapsulation:** Private fields and getter methods
- **Inheritance:** Rider and Driver inherit from User; Bike, Car, and Rickshaw inherit from Vehicle
- **Abstraction:** Abstract User and Vehicle classes
- **Polymorphism:** Different vehicle classes implement their own fare calculation
- **Interface:** Payable interface for payment processing
- **Enum:** PaymentMode for payment options

## Project Classes
- `Main.java` – Main menu and application execution
- `User.java` – Abstract parent class for users
- `Rider.java` – Rider registration and details
- `Driver.java` – Driver details and ride acceptance
- `Vehicle.java` – Abstract vehicle class and vehicle types
- `Location.java` – Location data and distance calculation
- `Ride.java` – Ride booking, fare calculation, completion, and payment
- `Rating.java` – Driver rating and feedback
- `Payable.java` – Payment interface
- `PaymentMode.java` – Payment method enumeration

## How to Run

1. Install JDK 21 or a compatible Java version.
2. Open the project folder in VS Code.
3. Compile the Java files.
4. Run the `Main.java` file.

## Important Note
This is an educational console-based project. Distance is calculated using geographic coordinates and the Haversine formula, so it represents an approximate straight-line distance rather than actual road distance. It does not use live GPS, a database, or a real payment gateway.

## Project Purpose
This project was developed to understand and demonstrate Java Object-Oriented Programming concepts through a practical ride-booking application.
