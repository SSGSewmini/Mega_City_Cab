<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.User" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"admin".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
<head>
    <title>Admin Dashboard | MegaCityCab</title>
    <link rel="stylesheet" type="text/css" href="css/admin.css">
    <script src="js/admin.js"></script>
</head>
<body>
    <div class="container">
        <h2>Welcome, Admin</h2>
        
        <ul class="admin-menu">
            <li><a href="manageUsers.jsp">Manage Users</a></li>
            <li><a href="manageBookings.jsp">Manage Bookings</a></li>
            <li><a href="manageBills.jsp">Manage Bills</a></li>
            <li><a href="reports.jsp">View Reports</a></li>
        </ul>

        <a href="logout.jsp" class="logout-btn" onclick="return confirmLogout();">Logout</a>
    </div>
</body>
</html>
