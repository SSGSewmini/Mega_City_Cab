<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.Booking, dao.BookingDAO" %>

<%
    User admin = (User) session.getAttribute("user");
    if (admin == null || !"admin".equals(admin.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }

    BookingDAO bookingDAO = new BookingDAO();
    List<Booking> bookings = bookingDAO.getAllBookings();
%>

<html>
<head>
    <title>Manage Bookings</title>
    <link rel="stylesheet" type="text/css" href="css/bookings.css">
    <script src="js/bookings.js"></script>
</head>
<body>
    <div class="container">
        <h2>All Bookings</h2>

        <table>
            <tr>
                <th>Booking ID</th>
                <th>Customer ID</th>
                <th>Pickup Location</th>
                <th>Dropoff Location</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            <% for (Booking b : bookings) { %>
                <tr>
                    <td><%= b.getBookingId() %></td>
                    <td><%= b.getCustomerId() %></td>
                    <td><%= b.getPickupLocation() %></td>
                    <td><%= b.getDropoffLocation() %></td>
                    <td><%= b.getStatus() %></td>
                    <td>
                        <a href="editBooking.jsp?id=<%= b.getBookingId() %>" class="action-btn edit-btn">Edit</a>
                        <a href="DeleteBookingServlet?id=<%= b.getBookingId() %>" class="action-btn delete-btn" onclick="return confirmBookingDelete();">Delete</a>
                    </td>
                </tr>
            <% } %>
        </table>

        <p><a href="adminDashboard.jsp">Back to Dashboard</a></p>
    </div>
</body>
</html>
