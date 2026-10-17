package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static CherryCars company = new CherryCars();
    private static Customer customer = new Customer("123ABC");
    private static Scanner kybd = new Scanner(System.in);

    public static void main(String[] args) {
        populateCherryCars();
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();
            processChoice(choice);
        } while (choice != -1);
        kybd.close();
    }

    private static void populateCherryCars() {

        company.addVehicle(new Electric("Tesla", "Model 3", 2022, "AA11 AAA", 4, 320));

        company.addVehicle(new Electric("Nissan", "Leaf", 2021, "BB22 BBB", 4, 220));

        company.addVehicle(new Electric("BMW", "i4", 2023, "CC33 CCC", 4, 300));

        company.addVehicle(new NonElectric("Ford", "Focus", 2019, "DD44 DDD", 4, "Petrol"));

        company.addVehicle(new NonElectric("Ford", "Escort", 2020, "EE55 EEE", 4, "Petrol"));

        company.addVehicle(new NonElectric("Volkswagen", "Golf", 2020, "FF66 FFF", 4, "Diesel"));

        company.addVehicle(new NonElectric("Audi", "A4", 2018, "GG77 GGG", 4, "Petrol"));

        company.addVehicle(new Motorbike("Yamaha", "R1", 2021, "HH88 HHH", false));

        company.addVehicle(new Motorbike("Harley-Davidson", "Street Glide", 2020, "II99 III", true));

        company.addVehicle(new Motorbike("Kawasaki", "Ninja 650", 2022, "JJ00 JJJ", false));

    }

    private static void displayMenu() {
        System.out.println("\nCherryCars System Menu:");
        System.out.println("1. List all vehicles");
        System.out.println("2. List available vehicles by make");
        System.out.println("3. rent a vehicle");
        System.out.println("4. return a vehicle");
        System.out.println("5. Calculate cost of renting");
        System.out.println("6. Show current rentals by customer");
        System.out.println("7. Show previous rentals by customer");
        
        System.out.println("-1. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        int choice = kybd.nextInt();
        kybd.nextLine();
        return choice;
    }

    private static void processChoice(int choice) {
        switch (choice) {
            case 1:
                viewVehicles();
                break;
            case 2:
                getVehicleByMake();
                break;
            case 3:
                rentVehicle();
                break;
            case 4:
                returnVehicle();
                break;
            case 5:
                calculateCost();
                break;
            case 6:
                viewCurrentRentals();
                break;
            case 7:
                viewPreviousRentals();
                break;

            case -1:
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option");
        }
    }

    private static void viewVehicles() {
        ArrayList<Vehicle> vehicles = company.getVehicles();
        if (vehicles.isEmpty()) {
            System.out.println("Sorry! no vehicles found");
        } else {
            System.out.println("Vehicles found");
            for (Vehicle v : vehicles) {
                System.out.println(v.toString());
            }
        }
    }

    private static void getVehicleByMake() {
        System.out.print("Enter the make to search for: ");
        String make = kybd.nextLine();
        ArrayList<Vehicle> vehicles = company.getVehicleByMake(make);

        if (vehicles.isEmpty()) {
            System.out.println("No make of " + make + " was found");
        } else {
            System.out.println("Vehicles by " + make + ":");
            for (Vehicle v : vehicles) {
                System.out.println(v.toString());
            }
        }
    }

    private static void rentVehicle() {
        System.out.print("Enter registration number: ");
        String reg = kybd.nextLine();

        if (company.rentVehicle(reg, customer)) {
            System.out.println(reg + " successfully rented");
        } else {
            System.out.println(reg + " doesn't exist or is already rented");
        }
    }

    private static void returnVehicle() {
        System.out.print("Enter registration number: ");
        String reg = kybd.nextLine();
        if (company.returnVehicle(reg, customer)) {
            System.out.println(reg + " successfully returned");
        } else {
            System.out.println(reg + " Return failed, Sorry!");
        }
    }

    private static void calculateCost() {
        System.out.println("Enter registration number:");
        String reg = kybd.nextLine();

        System.out.println("How many days you going for?: ");
        int days = kybd.nextInt();
        kybd.nextLine();

        double cost = company.calculateCost(reg, days);

        System.out.println("Cost = £" + cost);
    }

    private static void viewCurrentRentals() {
        ArrayList<Vehicle> rentalList = customer.getCurrentRentals();
        if (rentalList.isEmpty()) {
            System.out.println("Unfortunately, no current rentals");
        } else {
            for (Vehicle v : rentalList) {
                System.out.println(v);
            }
            ;
        }
    }

    private static void viewPreviousRentals() {
        ArrayList<Vehicle> rentalList = customer.getPreviousRentals();

        if (rentalList.isEmpty()) {
            System.out.println("No previous rentals");
        } else

        {
            for (Vehicle v : rentalList) {
                System.out.println(v);
            }
        }
    }
}
