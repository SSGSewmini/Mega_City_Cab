<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.User, dao.UserDAO" %>

<%
    User admin = (User) session.getAttribute("user");
    if (admin == null || !"admin".equals(admin.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }

    UserDAO userDAO = new UserDAO();
    List<User> users = userDAO.getAllUsers();
%>

<html>
<head>
    <title>Manage Users</title>
    <link rel="stylesheet" type="text/css" href="css/users.css">
    <script src="js/users.js"></script>
</head>
<body>
    <div class="container">
        <h2>All Users</h2>

        <table>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Role</th>
                <th>Actions</th>
            </tr>
            <% for (User u : users) { %>
                <tr>
                    <td><%= u.getId() %></td>
                    <td><%= u.getUsername() %></td>
                    <td><%= u.getRole() %></td>
                    <td>
                        <a href="editUser.jsp?id=<%= u.getId() %>" class="action-btn edit-btn">Edit</a>
                        <a href="DeleteUserServlet?id=<%= u.getId() %>" class="action-btn delete-btn" onclick="return confirmUserDelete();">Delete</a>
                    </td>
                </tr>
            <% } %>
        </table>

        <p><a href="adminDashboard.jsp">Back to Dashboard</a></p>
    </div>
</body>
</html>
