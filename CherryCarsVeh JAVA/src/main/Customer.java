package main;

import java.util.ArrayList;

public class Customer {
    private String licence;
    private ArrayList<Vehicle> currentRentals;
    private ArrayList<Vehicle> previousRentals;
    
    public Customer(String licence) {
        this.licence = licence;
        currentRentals = new ArrayList<>();
        previousRentals = new ArrayList<>();
    }

    public String getLicence() {
        return licence;
    }

    public ArrayList<Vehicle> getCurrentRentals() {
        return currentRentals;
    }

    public ArrayList<Vehicle> getPreviousRentals() {
        return previousRentals;
    }

    public void hireVehicle(Vehicle vehicle) {
        currentRentals.add(vehicle);
    }

    public void returnVehicle(Vehicle vehicle) {
        currentRentals.remove(vehicle);
        previousRentals.add(vehicle);
    }
}
