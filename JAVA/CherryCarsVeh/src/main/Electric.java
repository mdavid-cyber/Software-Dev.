package main;

public class Electric extends Car {
    private int milesPerCharge;

    public Electric(String make, String model, int year, String reg, int numDoors, int milesPerCharge) {
        super(make, model, year, reg, numDoors);
        this.milesPerCharge = milesPerCharge;
    }

    public int getMilesPerCharge() {
        return milesPerCharge;
    }

    @Override
    public double calculateRental(int days) {
        return days * 120;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + " milesPerCharge=" + milesPerCharge;
    }

}
