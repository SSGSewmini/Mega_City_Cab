<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.Bill, model.User, dao.BillDAO" %>

<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    BillDAO billDAO = new BillDAO();
    List<Bill> bills = billDAO.getBillsByCustomer(user.getId());
%>

<html>
<head>
    <title>My Bills | MegaCityCab</title>
</head>
<body>
    <h2>My Bills</h2>

    <% if (bills.isEmpty()) { %>
        <p>You have no bills yet.</p>
    <% } else { %>
        <table border="1">
            <tr>
                <th>Bill ID</th>
                <th>Booking ID</th>
                <th>Amount</th>
                <th>Payment Status</th>
                <th>Action</th>
            </tr>
            <% for (Bill bill : bills) { %>
                <tr>
                    <td><%= bill.getBillId() %></td>
                    <td><%= bill.getBookingId() %></td>
                    <td>$<%= bill.getAmount() %></td>
                    <td><%= bill.getPaymentStatus() %></td>
                    <td>
                        <% if ("pending".equals(bill.getPaymentStatus())) { %>
                            <form action="BillServlet" method="post">
                                <input type="hidden" name="billId" value="<%= bill.getBillId() %>">
                                <button type="submit">Pay Now</button>
                            </form>
                        <% } else { %>
                            Paid
                        <% } %>
                    </td>
                </tr>
            <% } %>
        </table>
    <% } %>
</body>
</html>
