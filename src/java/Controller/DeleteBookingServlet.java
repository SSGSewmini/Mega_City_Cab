package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BookingDAO;

@WebServlet("/DeleteBookingServlet")
public class DeleteBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int bookingId = Integer.parseInt(request.getParameter("id"));

        BookingDAO bookingDAO = new BookingDAO();
        if (bookingDAO.deleteBooking(bookingId)) {
            response.sendRedirect("manageBookings.jsp?message=Booking Deleted Successfully!");
        } else {
            response.sendRedirect("manageBookings.jsp?error=Deletion Failed!");
        }
    }
}
