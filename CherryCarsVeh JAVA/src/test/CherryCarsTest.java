package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.CherryCars;
import main.Electric;
import main.Motorbike;
import main.NonElectric;
import main.Customer;
import main.Vehicle;

public class CherryCarsTest {
    CherryCars company;
    Vehicle v1;
    Vehicle v2;
    Vehicle v3;
    Customer person;

    @Before
    public void setup() {
        company = new CherryCars();
        person = new Customer("456DEF");

        v1 = new Motorbike("Suzuki", "S1", 2024, "FF22 FFF", true);
        v2 = new NonElectric("Honda", "H1", 2020, "GG33 GGG", 6, "Petrol");
        v3 = new Electric("Toyota", "YT3", 2008, "HH44 HHH", 6, 40);

    }

    @Test
    public void testGetVehicleByMake() {
        company.addVehicle(v1);
        company.addVehicle(v2);
        company.addVehicle(v3);
        assertEquals(1, company.getVehicleByMake("Suzuki").size());
    }

    @Test
    public void testReturnVehicle() {
        company.addVehicle(v2);
        assertFalse(company.returnVehicle("GG33 GGG", person));
        company.rentVehicle("GG33 GGG", person);
        assertTrue(company.returnVehicle("GG33 GGG", person));
        assertFalse(company.returnVehicle("HH33 HHH", person));
    }
}
