package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import main.Electric;

public class ElectricTest {
    Electric tesla;

    @Before
    public void setup() {
        tesla = new Electric("Tesla", "modelY", 2026, "DD22 DDD",  5, 20);
    }

    @Test
    public void testCalculateRental() {
        assertEquals(2400.00, tesla.calculateRental(20), 0.01);        
    }

    @Test
    public void testGetMilesPerCharge() {
        assertEquals(20, tesla.getMilesPerCharge());
    }

    @Test
    public void testToString() {
        assertEquals("Available: make=Tesla, model=modelY, year=2026, reg=DD22 DDD, licence= , numDoors=5 ,  milesPerCharge=20", tesla.toString());
    }
}

