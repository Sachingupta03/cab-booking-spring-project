package com.sachin.cab.booking;

import com.sachin.cab.booking.controller.UserController;
import com.sachin.cab.booking.controller.DriverController;
import com.sachin.cab.booking.controller.RideController;
import com.sachin.cab.booking.controller.PaymentController;
import com.sachin.cab.booking.model.Ride;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        UserController userController = context.getBean("userController", UserController.class);
        DriverController driverController = context.getBean("driverController", DriverController.class);
        RideController rideController = context.getBean("rideController", RideController.class);
        PaymentController paymentController = context.getBean("paymentController", PaymentController.class);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- CAB BOOKING MENU ---");
            System.out.println("1. Create User");
            System.out.println("2. Create Driver");
            System.out.println("3. Book Ride");
            System.out.println("4. Make Payment");
            System.out.println("5. List Users");
            System.out.println("6. List Drivers");
            System.out.println("7. List Rides");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Location: ");
                    String location = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    userController.createUser(userId, name, location, phone);
                    break;

                case 2:
                    System.out.print("Enter Driver ID: ");
                    int driverId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String dName = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String dPhone = sc.nextLine();
                    System.out.print("Enter License No: ");
                    String license = sc.nextLine();
                    System.out.print("Enter Experience (years): ");
                    int exp = sc.nextInt();
                    driverController.createDriver(driverId, dName, dPhone, license, exp);
                    break;

                case 3:
                    Ride ride = new Ride();
                    System.out.print("Enter Driver ID: ");
                    String rideDriverId = sc.nextLine();
                    System.out.print("Enter Passenger ID: ");
                    String passengerId = sc.nextLine();
                    System.out.print("Enter Pickup Location: ");
                    String pickup = sc.nextLine();
                    System.out.print("Enter Drop Location: ");
                    String drop = sc.nextLine();
                    System.out.print("Enter Distance (km): ");
                    double distance = sc.nextDouble();
                    System.out.print("Enter Fare: ");
                    double fare = sc.nextDouble();
                    System.out.print("Enter Driver Rating: ");
                    double dRating = sc.nextDouble();
                    System.out.print("Enter Passenger Rating: ");
                    double pRating = sc.nextDouble();

                    ride.setDriverId(rideDriverId);
                    ride.setPassengerId(passengerId);
                    ride.setPickupLocation(pickup);
                    ride.setDropoffLocation(drop);
                    ride.setDistance(distance);
                    ride.setFare(fare);
                    ride.setDriverRating(dRating);
                    ride.setPassengerRating(pRating);
                    ride.setStartTime(LocalDateTime.now());
                    ride.setEndTime(LocalDateTime.now().plusMinutes(20));

                    rideController.createRide(ride);
                    break;

                case 4:
                    System.out.print("Enter Ride ID: ");
                    String rideId = sc.nextLine();
                    System.out.print("Enter User ID: ");
                    String uid = sc.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Transaction ID: ");
                    String txn = sc.nextLine();
                    System.out.print("Enter Currency: ");
                    String currency = sc.nextLine();
                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter Status (SUCCESS/FAILURE): ");
                    String status = sc.nextLine();

                    paymentController.makePayment(rideId, uid, amount, txn, currency, desc, status);
                    break;

                case 5:
                    userController.listUsers();
                    break;

                case 6:
                    driverController.listDrivers();
                    break;

                case 7:
                    rideController.showAllRides();
                    break;

                case 8:
                    System.out.println("Thank you for using Cab Booking System!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid choice. Please try again.");
            }
        }
    }
}
