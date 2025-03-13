// Function to confirm booking deletion
function confirmBookingDelete() {
    return confirm("Are you sure you want to delete this booking?");
}

// Function to highlight the selected row in the table
document.addEventListener("DOMContentLoaded", function () {
    let tableRows = document.querySelectorAll("table tr");

    tableRows.forEach(row => {
        row.addEventListener("click", function () {
            tableRows.forEach(r => r.classList.remove("selected"));
            this.classList.add("selected");
        });
    });
});
