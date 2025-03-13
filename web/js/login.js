// Function to validate login form before submission
function validateLoginForm() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    if (username === "" || password === "") {
        alert("Both username and password are required!");
        return false; // Prevent form submission
    }
    return true; // Proceed with form submission
}

// Wait for the page to load before adding event listener
document.addEventListener("DOMContentLoaded", function () {
    let loginForm = document.getElementById("loginForm");
    if (loginForm) {
        loginForm.addEventListener("submit", function (event) {
            if (!validateLoginForm()) {
                event.preventDefault(); // Prevent form submission if validation fails
            }
        });
    }
});
