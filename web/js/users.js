// Function to confirm user deletion
function confirmUserDelete() {
    return confirm("Are you sure you want to delete this user?");
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
