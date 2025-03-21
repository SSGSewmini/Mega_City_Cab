package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BillDAO;

@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int billId = Integer.parseInt(request.getParameter("billId"));
        BillDAO billDAO = new BillDAO();

        if (billDAO.payBill(billId)) {
            response.sendRedirect("viewBills.jsp?message=Payment Successful!");
        } else {
            response.sendRedirect("viewBills.jsp?error=Payment Failed!");
        }
    }
}
