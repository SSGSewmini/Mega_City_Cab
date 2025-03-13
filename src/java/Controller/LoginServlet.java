package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDAO;
import model.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.validateUser(username, password);

        if (user != null) {
            // Start session and store user details
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());

            // Redirect based on role
            if (user.getRole().equals("admin")) {
                response.sendRedirect("adminDashboard.jsp");
            } else {
                response.sendRedirect("customerDashboard.jsp");
            }
        } else {
            // Invalid credentials, redirect back to login page with error message
            response.sendRedirect("login.jsp?error=Invalid Username or Password");
        }
    }
}
