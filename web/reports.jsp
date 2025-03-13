<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.ReportDAO, java.util.List" %>

<%
    ReportDAO reportDAO = new ReportDAO();
    double totalRevenue = reportDAO.getTotalRevenue();
    List<String[]> monthlyRevenue = reportDAO.getMonthlyRevenue();
%>

<html>
<head>
    <title>Reports | MegaCityCab</title>
    <link rel="stylesheet" type="text/css" href="css/reports.css">
    <script src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="js/reports.js"></script>
</head>
<body>
    <div class="container">
        <h2>Financial Reports</h2>

        <!-- Total Revenue -->
        <h3>Total Revenue: $<%= totalRevenue %></h3>

        <!-- Monthly Revenue Chart -->
        <div class="chart-container">
            <h3>Monthly Revenue</h3>
            <div id="monthlyRevenueChart"></div>
        </div>

        <!-- Hidden Data for Google Charts -->
        <script type="application/json" id="revenueData">
            <%= new com.google.gson.Gson().toJson(monthlyRevenue) %>
        </script>

        <p><a href="adminDashboard.jsp">Back to Dashboard</a></p>
    </div>
</body>
</html>
