package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Bill;
import util.DBConnection;

public class BillDAO {

    // ✅ Generate a Bill for a Booking
    public boolean generateBill(int bookingId, int customerId, double amount) {
        boolean isGenerated = false;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO bills (booking_id, customer_id, amount, payment_status) VALUES (?, ?, ?, 'pending')";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bookingId);
            ps.setInt(2, customerId);
            ps.setDouble(3, amount);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                isGenerated = true;
                System.out.println("✅ Bill Generated Successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isGenerated;
    }

    // ✅ Get All Bills for a Customer
    public List<Bill> getBillsByCustomer(int customerId) {
        List<Bill> bills = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM bills WHERE customer_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                bills.add(new Bill(
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
        return bills;
    }

    // ✅ Process Payment for a Bill
    public boolean payBill(int billId) {
        boolean isPaid = false;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE bills SET payment_status = 'paid', payment_date = NOW() WHERE bill_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, billId);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                isPaid = true;
                System.out.println("✅ Bill Paid Successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isPaid;
    }
    // ✅ Get All Bills
public List<Bill> getAllBills() {
    List<Bill> bills = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "SELECT * FROM bills";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            bills.add(new Bill(
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
    return bills;
}

// ✅ Mark Bill as Paid
public boolean markBillAsPaid(int billId) {
    boolean isUpdated = false;
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "UPDATE bills SET payment_status = 'paid', payment_date = NOW() WHERE bill_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, billId);

        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0) {
            isUpdated = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return isUpdated;
}

// ✅ Delete Bill
public boolean deleteBill(int billId) {
    boolean isDeleted = false;
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "DELETE FROM bills WHERE bill_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, billId);

        int rowsDeleted = ps.executeUpdate();
        if (rowsDeleted > 0) {
            isDeleted = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return isDeleted;
}

}
