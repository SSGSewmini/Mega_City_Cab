<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login | MegaCityCab</title>
</head>
<body>
    <h2>Login</h2>

    <!-- Show error message if login fails -->
    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Invalid Username or Password!</p>
    <% } %>

    <form action="LoginServlet" method="post">
        <label>Username:</label>
        <input type="text" name="username" required><br>
        
        <label>Password:</label>
        <input type="password" name="password" required><br>
        
        <button type="submit">Login</button>
    </form>

    <!-- Link to Register Page -->
    <p>New Customer? <a href="register.jsp">Register Here</a></p>
</body>
</html>
