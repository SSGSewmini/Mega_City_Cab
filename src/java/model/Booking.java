package model;

import java.sql.Timestamp;

public class Booking {
    private int bookingId;
    private int customerId;
    private String pickupLocation;
    private String dropoffLocation;
    private Timestamp bookingDate;
    private String status;

    public Booking() {}

    public Booking(int bookingId, int customerId, String pickupLocation, String dropoffLocation, Timestamp bookingDate, String status) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    // Getters and Setters
    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }

    public String getDropoffLocation() { return dropoffLocation; }
    public void setDropoffLocation(String dropoffLocation) { this.dropoffLocation = dropoffLocation; }

    public Timestamp getBookingDate() { return bookingDate; }
    public void setBookingDate(Timestamp bookingDate) { this.bookingDate = bookingDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
