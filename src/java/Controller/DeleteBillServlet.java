package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BillDAO;


@WebServlet("/DeleteBillServlet")
public class DeleteBillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int billId = Integer.parseInt(request.getParameter("id"));

        BillDAO billDAO = new BillDAO();
        if (billDAO.deleteBill(billId)) {
            response.sendRedirect("manageBills.jsp?message=Bill deleted successfully!");
        } else {
            response.sendRedirect("manageBills.jsp?error=Failed to delete bill!");
        }
    }
}
