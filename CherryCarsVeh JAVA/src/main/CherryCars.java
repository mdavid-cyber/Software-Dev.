package main;

import java.util.ArrayList;

public class CherryCars {
    private ArrayList<Vehicle> vehicles;

    public CherryCars() {
        vehicles = new ArrayList<>();
    }

    public boolean addVehicle(Vehicle vehicle) {
        Vehicle v = findVehicle(vehicle.getReg());
        if (v == null) {
            vehicles.add(vehicle);
            return true;
        }
        return false;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public Vehicle findVehicle(String reg) {
        for (Vehicle v : vehicles) {
            if (v.getReg().equalsIgnoreCase(reg)) {
                return v;
            }
        }
        return null;
    }

    public ArrayList<Vehicle> getVehicleByMake(String make) {
        ArrayList<Vehicle> makeVehicle = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getMake().equalsIgnoreCase(make) && v.isAvailable()) {
                makeVehicle.add(v);
            }
        }
        return makeVehicle;
    }

    public boolean rentVehicle(String reg, Customer customer) {
        Vehicle v = findVehicle(reg);
        if (v == null) {
            return false;
        } else if (v != null && v.isAvailable()) {

            v.setLicence(customer.getLicence());
            customer.hireVehicle(v);

            return true;
        } else {
            System.out.println("Vehicle not available");
        }
        return false;
    }

    public boolean returnVehicle(String reg, Customer customer) {
        Vehicle v = findVehicle(reg);
        if (v == null) {
            return false;
        }
        if (!v.getLicence().equals(customer.getLicence())) {
            return false;
        }

        customer.returnVehicle(v);
        v.setLicence("");

        return true;
    }

    public double calculateCost(String reg, int days) {
        Vehicle v = findVehicle(reg);

        if (v == null) {
            return 0;
        }

        return v.calculateRental(days);
    }
}
