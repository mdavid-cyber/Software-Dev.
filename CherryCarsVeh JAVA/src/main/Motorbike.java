package main;

public class Motorbike extends Vehicle {
    private boolean sidecar;

    public Motorbike(String make, String model, int year, String reg, boolean sidecar) {
        super(make, model, year, reg);
        this.sidecar = sidecar;
    }

    public boolean isSidecar() {
        return sidecar;
    }

    @Override
    public double calculateRental(int days) {
        return days * 150;
    }

    @Override
    public String toString() {
        return super.toString() + ", "+ " sidecar=" + sidecar;
    }

}
