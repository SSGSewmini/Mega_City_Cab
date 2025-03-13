package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BookingDAO;
import model.Booking;

@WebServlet("/EditBookingServlet")
public class EditBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int bookingId = Integer.parseInt(request.getParameter("id"));
        String pickupLocation = request.getParameter("pickupLocation");
        String dropoffLocation = request.getParameter("dropoffLocation");
        String status = request.getParameter("status");

        BookingDAO bookingDAO = new BookingDAO();
        Booking booking = new Booking(bookingId, 0, pickupLocation, dropoffLocation, null, status);

        if (bookingDAO.updateBooking(booking)) {
            response.sendRedirect("manageBookings.jsp?message=Booking Updated Successfully!");
        } else {
            response.sendRedirect("editBooking.jsp?id=" + bookingId + "&error=Update Failed!");
        }
    }
}
