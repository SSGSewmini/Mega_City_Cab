<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.Booking, model.User, dao.BookingDAO" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    BookingDAO bookingDAO = new BookingDAO();
    List<Booking> bookings = bookingDAO.getBookingsByCustomer(user.getId());
%>

<html>
<head>
    <title>My Bookings | MegaCityCab</title>
</head>
<body>
    <h2>My Bookings</h2>

    <% if (bookings.isEmpty()) { %>
        <p>You have no bookings yet.</p>
    <% } else { %>
        <table border="1">
            <tr>
                <th>Booking ID</th>
                <th>Pickup Location</th>
                <th>Dropoff Location</th>
                <th>Booking Date</th>
                <th>Status</th>
            </tr>
            <% for (Booking booking : bookings) { %>
                <tr>
                    <td><%= booking.getBookingId() %></td>
                    <td><%= booking.getPickupLocation() %></td>
                    <td><%= booking.getDropoffLocation() %></td>
                    <td><%= booking.getBookingDate() %></td>
                    <td><%= booking.getStatus() %></td>
                </tr>
            <% } %>
        </table>
    <% } %>

    <p><a href="booking.jsp">Book Another Ride</a></p>
</body>
</html>
