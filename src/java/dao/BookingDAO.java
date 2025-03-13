package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public List<Booking> getAllBookings() {
    List<Booking> bookings = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "SELECT * FROM bookings";
        PreparedStatement ps = conn.prepareStatement(sql);
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
// ✅ Get Booking by ID
public Booking getBookingById(int bookingId) {
    Booking booking = null;
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "SELECT * FROM bookings WHERE booking_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, bookingId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            booking = new Booking(
                rs.getInt("booking_id"),
                rs.getInt("customer_id"),
                rs.getString("pickup_location"),
                rs.getString("dropoff_location"),
                rs.getTimestamp("booking_date"),
                rs.getString("status")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return booking;
}

// ✅ Update Booking
public boolean updateBooking(Booking booking) {
    boolean isUpdated = false;
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "UPDATE bookings SET pickup_location = ?, dropoff_location = ?, status = ? WHERE booking_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, booking.getPickupLocation());
        ps.setString(2, booking.getDropoffLocation());
        ps.setString(3, booking.getStatus());
        ps.setInt(4, booking.getBookingId());

        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0) {
            isUpdated = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return isUpdated;
}

// ✅ Delete Booking
public boolean deleteBooking(int bookingId) {
    boolean isDeleted = false;
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "DELETE FROM bookings WHERE booking_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, bookingId);

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
