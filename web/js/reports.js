// Load Google Charts API
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawMonthlyRevenueChart);

// Function to draw monthly revenue chart
function drawMonthlyRevenueChart() {
    let data = new google.visualization.DataTable();
    data.addColumn('string', 'Month');
    data.addColumn('number', 'Revenue');

    // Fetch revenue data from JSP
    let revenueData = JSON.parse(document.getElementById("revenueData").textContent);
    data.addRows(revenueData);

    let options = {
        title: 'Monthly Revenue Report',
        width: 700,
        height: 400,
        colors: ['#007bff'],
        hAxis: { title: 'Month' },
        vAxis: { title: 'Revenue ($)' }
    };

    let chart = new google.visualization.ColumnChart(document.getElementById('monthlyRevenueChart'));
    chart.draw(data, options);
}
