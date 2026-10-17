package main;

public class NonElectric extends Car {
    private String fuelType;

    public NonElectric(String make, String model, int year, String reg, int numDoors, String fuelType) {
        super(make, model, year, reg, numDoors);
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public double calculateRental(int days) {
       return days * 100;
    }   

    @Override
    public String toString() {
        return super.toString() + "," + " fuelType=" + fuelType;
    }
    
}
