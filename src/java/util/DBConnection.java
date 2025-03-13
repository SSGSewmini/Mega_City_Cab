package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/cab_booking"; // Database Name
    private static final String USER = "root"; // MySQL Username
    private static final String PASSWORD = ""; // MySQL Password (Update if needed)

    // Method to establish database connection
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database Connected Successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Database Connection Failed!");
        }
        return conn;
    }

    // Method to close connection
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("🔌 Database Connection Closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

