package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDAO;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("id"));

        UserDAO userDAO = new UserDAO();
        if (userDAO.deleteUser(userId)) {
            response.sendRedirect("manageUsers.jsp?message=User Deleted Successfully!");
        } else {
            response.sendRedirect("manageUsers.jsp?error=Deletion Failed!");
        }
    }
}
