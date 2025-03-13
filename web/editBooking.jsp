<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Booking, dao.BookingDAO" %>

<%
    int bookingId = Integer.parseInt(request.getParameter("id"));
    BookingDAO bookingDAO = new BookingDAO();
    Booking booking = bookingDAO.getBookingById(bookingId);
%>

<html>
<head>
    <title>Edit Booking</title>
</head>
<body>
    <h2>Edit Booking</h2>

    <form action="EditBookingServlet" method="post">
        <input type="hidden" name="id" value="<%= booking.getBookingId() %>">
        
        <label>Pickup Location:</label>
        <input type="text" name="pickupLocation" value="<%= booking.getPickupLocation() %>" required><br>

        <label>Dropoff Location:</label>
        <input type="text" name="dropoffLocation" value="<%= booking.getDropoffLocation() %>" required><br>

        <label>Status:</label>
        <select name="status">
            <option value="pending" <% if ("pending".equals(booking.getStatus())) { %>selected<% } %>>Pending</option>
            <option value="confirmed" <% if ("confirmed".equals(booking.getStatus())) { %>selected<% } %>>Confirmed</option>
            <option value="completed" <% if ("completed".equals(booking.getStatus())) { %>selected<% } %>>Completed</option>
            <option value="cancelled" <% if ("cancelled".equals(booking.getStatus())) { %>selected<% } %>>Cancelled</option>
        </select><br>

        <button type="submit">Update Booking</button>
    </form>

    <p><a href="manageBookings.jsp">Back to Bookings</a></p>
</body>
</html>
