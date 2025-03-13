<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register | MegaCityCab</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
    <script src="js/register.js"></script>
</head>
<body>
    <div class="container">
        <h2>Register</h2>
        <form id="registerForm" action="RegisterServlet" method="post">
            <label>Username:</label>
            <input type="text" name="username" id="username" required class="input-field"><br>

            <label>Password:</label>
            <input type="password" name="password" id="password" required class="input-field"><br>

            <label>Confirm Password:</label>
            <input type="password" name="confirmPassword" id="confirmPassword" required class="input-field"><br>

            <span id="togglePasswordText" class="toggle-password" onclick="togglePassword()">Show Password</span>

            <label>Role:</label>
            <select name="role" class="input-field">
                <option value="customer">Customer</option>
            </select><br>

            <button type="submit">Register</button>
        </form>
    </div>
</body>
</html>
