// Function to confirm logout
function confirmLogout() {
    return confirm("Are you sure you want to log out?");
}

// Function to highlight the clicked menu item
document.addEventListener("DOMContentLoaded", function () {
    let menuLinks = document.querySelectorAll(".admin-menu a");

    menuLinks.forEach(link => {
        link.addEventListener("click", function () {
            menuLinks.forEach(item => item.classList.remove("active"));
            this.classList.add("active");
        });
    });
});
