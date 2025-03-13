package model;

import java.sql.Timestamp;

public class Bill {
    private int billId;
    private int bookingId;
    private int customerId;
    private double amount;
    private String paymentStatus;
    private Timestamp paymentDate;

    public Bill() {}

    public Bill(int billId, int bookingId, int customerId, double amount, String paymentStatus, Timestamp paymentDate) {
        this.billId = billId;
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }

    // Getters and Setters
    public int getBillId() { return billId; }
    public void setBillId(int billId) { this.billId = billId; }

    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public Timestamp getPaymentDate() { return paymentDate; }
    public void setPaymentDate(Timestamp paymentDate) { this.paymentDate = paymentDate; }
}
