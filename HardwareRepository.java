package hardware;

import java.sql.*;
import java.util.ArrayList;

public class HardwareRepository {

    // --- Database Configuration ---
    private static final String URL = "jdbc:mysql://localhost:3306/hardware_db";
    private static final String USER = "root";
    private static final String PASS = "WJ28@krhps";

    // Merged Connection Helper
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static ArrayList<Hardware> getHardwareList() {
        ArrayList<Hardware> list = new ArrayList<>();
        String query = "SELECT * FROM items";

        // Connection is now handled directly via the internal method
        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                String brand = rs.getString("brand");
                String type = rs.getString("type");
                int spec = rs.getInt("spec");

                if (type.equalsIgnoreCase("Laptop")) {
                    list.add(new Laptop(brand, spec));
                } else if (type.equalsIgnoreCase("Phone")) {
                    list.add(new Phone(brand, spec));
                }
            }
        } catch (SQLException e) {
            System.out.println("Fetch error: " + e.getMessage());
        }
        return list;
    }

    public static void addHardwareToDatabase(String brand, String type, int spec) {
        String query = "INSERT INTO items (brand, type, spec) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, brand);
            pstmt.setString(2, type);
            pstmt.setInt(3, spec);
            pstmt.executeUpdate();
            System.out.println(">>> SUCCESS: Item saved to MySQL! <<<");

        } catch (SQLException e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }
}