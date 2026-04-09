package hardware;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/hardware_db";
            String user = "root";
            String pass = "WJ28@krhps"; 
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
            return null;
        }
    }
}