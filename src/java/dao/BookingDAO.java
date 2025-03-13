package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Booking;
import util.DBConnection;

public class BookingDAO {

    // ✅ Add New Booking
    public boolean addBooking(Booking booking) {
        boolean isAdded = false;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO bookings (customer_id, pickup_location, dropoff_location, status) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, booking.getCustomerId());
            ps.setString(2, booking.getPickupLocation());
            ps.setString(3, booking.getDropoffLocation());
            ps.setString(4, booking.getStatus());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                isAdded = true;
                System.out.println("✅ Booking Added Successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    // ✅ Get All Bookings for a Customer
    public List<Booking> getBookingsByCustomer(int customerId) {
        List<Booking> bookings = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM bookings WHERE customer_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                bookings.add(new Booking(
                    rs.getInt("booking_id"),
                    rs.getInt("customer_id"),
                    rs.getString("pickup_location"),
                    rs.getString("dropoff_location"),
                    rs.getTimestamp("booking_date"),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}
