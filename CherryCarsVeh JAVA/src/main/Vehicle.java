package main;

public abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected String reg;
    protected String licence;

    public Vehicle(String make, String model, int year, String reg) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.reg = reg;
        this.licence = "";
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getReg() {
        return reg;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public boolean isAvailable() {
        return licence.isEmpty();
    }

    @Override
    public String toString() {  
        String store;
        
        if (isAvailable()) {
            store = "Available: ";
        } else {
            store = "Not Available: ";
        }

        return store + "make=" + make + ", model=" + model + ", year=" + year + ", reg=" + reg + ", licence=" + licence;
    }

    public abstract double calculateRental(int days);    
}
