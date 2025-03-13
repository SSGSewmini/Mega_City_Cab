<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register | MegaCityCab</title>
</head>
<body>
    <h2>Register</h2>

    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;"><%= request.getParameter("error") %></p>
    <% } %>

    <form action="RegisterServlet" method="post">
        <label>Username:</label>
        <input type="text" name="username" required><br>

        <label>Password:</label>
        <input type="password" name="password" required><br>

        <button type="submit">Register</button>
    </form>

    <!-- Link to Login Page -->
    <p>Already have an account? <a href="login.jsp">Login here</a></p>
</body>
</html>
