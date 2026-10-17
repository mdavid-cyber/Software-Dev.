package main;

public abstract class Car extends Vehicle {
    protected int numDoors;

    public Car(String make, String model, int year, String reg, int numDoors) {
        super(make, model, year, reg);
        this.numDoors = numDoors;
    }

    public int getNumDoors() {
        return numDoors;
    }

    @Override
    public String toString() {
        return super.toString() + " ," + " numDoors=" + numDoors + " ";
    }

}
