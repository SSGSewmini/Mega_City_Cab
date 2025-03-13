package TestPackages;

import util.DBConnection;
import java.sql.Connection;

public class TestDBConnection {
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("✅ Connection Test Passed!");
        } else {
            System.out.println("❌ Connection Test Failed!");
        }
        DBConnection.closeConnection(conn);
    }
}
