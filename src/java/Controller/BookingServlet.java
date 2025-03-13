package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.BookingDAO;
import model.Booking;
import model.User;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int customerId = user.getId();
        String pickupLocation = request.getParameter("pickupLocation");
        String dropoffLocation = request.getParameter("dropoffLocation");

        Booking booking = new Booking(0, customerId, pickupLocation, dropoffLocation, null, "pending");
        BookingDAO bookingDAO = new BookingDAO();

        if (bookingDAO.addBooking(booking)) {
            response.sendRedirect("viewBookings.jsp?message=Booking Successful!");
        } else {
            response.sendRedirect("booking.jsp?error=Booking Failed!");
        }
    }
}
