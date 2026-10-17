package main;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/vehicledb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static ArrayList<Vehicle> fetchVehicles() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        String sql = "SELECT * FROM vehicle";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int vehicleid = rs.getInt("vehicleid");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String regNum = rs.getString("reg_num");
                int year = rs.getInt("year");
                String type = rs.getString("type");

                if (type.equalsIgnoreCase("car")) {

                    
                           vehicles.add(fetchCar(conn, vehicleid, make, model, regNum, year));
                    
                } else if (type.equalsIgnoreCase("motorbike")) {

                    vehicles.add(
                            fetchMotorbike(conn, vehicleid, make, model, regNum, year));
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return vehicles;
    }

    private static Car fetchCar(Connection conn, int vehicleid, String make, String model, String regNum, int year)

            throws SQLException {

        String sql = "SELECT * FROM car WHERE vehicleid = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicleid);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    int numDoors = rs.getInt("num_doors");
                    String fuelType = rs.getString("fuel_type");
                    int batteryRange = rs.getInt("battery_range");
                    String category = rs.getString("category");

                    if (category == "Electric") {
                        return new Electric(make, model, year, regNum, numDoors, batteryRange);
                    } else {
                        return new NonElectric(make, model, year, regNum, numDoors, fuelType);
                    }
                }
            }
        }

        return null;
    }

    private static Motorbike fetchMotorbike(Connection conn, int vehicleid, String make, String model, String regNum,
            int year) throws SQLException {

        String sql = "SELECT * FROM motorbike WHERE vehicleid = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vehicleid);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    boolean hasSidecar = rs.getBoolean("has_sidecar");

                    return new Motorbike(make, model, year, regNum, hasSidecar);
                }
            }
        }

        return null;
    }
}