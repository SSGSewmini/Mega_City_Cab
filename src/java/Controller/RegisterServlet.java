package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDAO;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = "customer"; // Default role for new users

        User newUser = new User(0, username, password, role);
        UserDAO userDAO = new UserDAO();

        boolean isRegistered = userDAO.registerUser(newUser);

        if (isRegistered) {
            response.sendRedirect("login.jsp?message=Registration Successful! Please Login.");
        } else {
            response.sendRedirect("register.jsp?error=Registration Failed. Username may be taken.");
        }
    }
}
