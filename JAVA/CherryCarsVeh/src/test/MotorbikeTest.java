package test;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;
import main.Motorbike;

public class MotorbikeTest {
    Motorbike kawasaki;

    @Before
    public void setup() {
        kawasaki = new Motorbike("Kawasaki","K1", 2026, "EE44 EEE", false);
    }

    @Test
    public void testCalculateRental() {
        assertEquals(1500.0, kawasaki.calculateRental(10), 0.01 );
    }

    @Test
    public void testIsSidecar() {
        assertEquals(false, kawasaki.isSidecar());
    }

    @Test
    public void testToString() {
        assertEquals("Available: make=Kawasaki, model=K1, year=2026, reg=EE44 EEE, licence=,  sidecar=false", kawasaki.toString());
    }
}
