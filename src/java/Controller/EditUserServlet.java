package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDAO;
import model.User;

@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String role = request.getParameter("role");

        UserDAO userDAO = new UserDAO();
        User user = new User(userId, username, "", role);

        if (userDAO.updateUser(user)) {
            response.sendRedirect("manageUsers.jsp?message=User Updated Successfully!");
        } else {
            response.sendRedirect("editUser.jsp?id=" + userId + "&error=Update Failed!");
        }
    }
}
