<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.Bill, dao.BillDAO" %>

<%
    User admin = (User) session.getAttribute("user");
    if (admin == null || !"admin".equals(admin.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }

    BillDAO billDAO = new BillDAO();
    List<Bill> bills = billDAO.getAllBills();
%>

<html>
<head>
    <title>Manage Bills</title>
    <link rel="stylesheet" type="text/css" href="css/bills.css">
    <script src="js/bills.js"></script>
</head>
<body>
    <div class="container">
        <h2>All Bills</h2>

        <table>
            <tr>
                <th>Bill ID</th>
                <th>Booking ID</th>
                <th>Customer ID</th>
                <th>Amount</th>
                <th>Payment Status</th>
                <th>Actions</th>
            </tr>
            <% for (Bill b : bills) { %>
                <tr>
                    <td><%= b.getBillId() %></td>
                    <td><%= b.getBookingId() %></td>
                    <td><%= b.getCustomerId() %></td>
                    <td>$<%= b.getAmount() %></td>
                    <td><%= b.getPaymentStatus() %></td>
                    <td>
                        <% if ("pending".equals(b.getPaymentStatus())) { %>
                            <a href="MarkBillPaidServlet?id=<%= b.getBillId() %>" class="action-btn pay-btn" onclick="return confirmBillPayment();">Mark as Paid</a> |
                        <% } %>
                        <a href="DeleteBillServlet?id=<%= b.getBillId() %>" class="action-btn delete-btn" onclick="return confirmBillDelete();">Delete</a>
                    </td>
                </tr>
            <% } %>
        </table>

        <p><a href="adminDashboard.jsp">Back to Dashboard</a></p>
    </div>
</body>
</html>
