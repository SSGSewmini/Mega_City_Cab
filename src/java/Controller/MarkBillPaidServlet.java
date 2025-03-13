package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BillDAO;

@WebServlet("/MarkBillPaidServlet")
public class MarkBillPaidServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int billId = Integer.parseInt(request.getParameter("billId"));

        BillDAO billDAO = new BillDAO();
        if (billDAO.markBillAsPaid(billId)) {
            response.sendRedirect("manageBills.jsp?message=Bill Marked as Paid Successfully!");
        } else {
            response.sendRedirect("manageBills.jsp?error=Failed to Mark Bill as Paid!");
        }
    }
}
