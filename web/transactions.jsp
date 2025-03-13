<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.Bill, dao.ReportDAO" %>

<%
    ReportDAO reportDAO = new ReportDAO();
    List<Bill> transactions = reportDAO.getRecentTransactions();
%>

<html>
<head>
    <title>Payment Transactions</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Bill ID</th>
            <th>Booking ID</th>
            <th>Customer ID</th>
            <th>Amount</th>
            <th>Payment Date</th>
        </tr>
        <% for (Bill bill : transactions) { %>
            <tr>
                <td><%= bill.getBillId() %></td>
                <td><%= bill.getBookingId() %></td>
                <td><%= bill.getCustomerId() %></td>
                <td>$<%= bill.getAmount() %></td>
                <td><%= bill.getPaymentDate() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
