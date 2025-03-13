// Function to confirm bill deletion
function confirmBillDelete() {
    return confirm("Are you sure you want to delete this bill?");
}

// Function to confirm bill payment
function confirmBillPayment() {
    return confirm("Are you sure you want to mark this bill as paid?");
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
