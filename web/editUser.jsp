<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.User, dao.UserDAO" %>

<%
    UserDAO userDAO = new UserDAO();
    int userId = Integer.parseInt(request.getParameter("id"));
    User user = userDAO.getUserById(userId);
%>

<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h2>Edit User</h2>

    <form action="EditUserServlet" method="post">
        <input type="hidden" name="id" value="<%= user.getId() %>">

        <label>Username:</label>
        <input type="text" name="username" value="<%= user.getUsername() %>" required><br>

        <label>Role:</label>
        <select name="role">
            <option value="admin" <%= user.getRole().equals("admin") ? "selected" : "" %>>Admin</option>
            <option value="customer" <%= user.getRole().equals("customer") ? "selected" : "" %>>Customer</option>
        </select><br>

        <button type="submit">Update</button>
    </form>

    <p><a href="manageUsers.jsp">Back to Users</a></p>
</body>
</html>
