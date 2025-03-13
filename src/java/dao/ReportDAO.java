package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import model.Bill;

public class ReportDAO {

    // ✅ Get Total Revenue (Sum of Paid Bills)
    public double getTotalRevenue() {
        double totalRevenue = 0.0;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT SUM(amount) AS total FROM bills WHERE payment_status = 'paid'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                totalRevenue = rs.getDouble("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalRevenue;
    }

    // ✅ Get Monthly Revenue Report
    public List<String[]> getMonthlyRevenue() {
        List<String[]> monthlyRevenue = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT DATE_FORMAT(payment_date, '%Y-%m') AS month, SUM(amount) AS revenue " +
                         "FROM bills WHERE payment_status = 'paid' GROUP BY month ORDER BY month DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String month = rs.getString("month");
                String revenue = String.valueOf(rs.getDouble("revenue"));
                monthlyRevenue.add(new String[]{month, revenue});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return monthlyRevenue;
    }

    // ✅ Get All Payment Transactions
    public List<Bill> getAllTransactions() {
        List<Bill> transactions = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM bills WHERE payment_status = 'paid' ORDER BY payment_date DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                transactions.add(new Bill(
                    rs.getInt("bill_id"),
                    rs.getInt("booking_id"),
                    rs.getInt("customer_id"),
                    rs.getDouble("amount"),
                    rs.getString("payment_status"),
                    rs.getTimestamp("payment_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
