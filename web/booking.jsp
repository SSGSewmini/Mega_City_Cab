<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, model.User" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
<head>
    <title>Book a Ride | MegaCityCab</title>
</head>
<body>
    <h2>Book a Ride</h2>

    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;"><%= request.getParameter("error") %></p>
    <% } %>

    <form action="BookingServlet" method="post">
        <label>Pickup Location:</label>
        <input type="text" name="pickupLocation" required><br>

        <label>Dropoff Location:</label>
        <input type="text" name="dropoffLocation" required><br>

        <button type="submit">Book Now</button>
    </form>

    <p><a href="viewBookings.jsp">View My Bookings</a></p>
</body>
</html>
