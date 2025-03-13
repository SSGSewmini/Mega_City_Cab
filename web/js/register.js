// Function to validate registration form
function validateRegisterForm() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;

    if (username === "" || password === "" || confirmPassword === "") {
        alert("All fields are required!");
        return false;
    }
    if (password.length < 6) {
        alert("Password must be at least 6 characters long!");
        return false;
    }
    if (password !== confirmPassword) {
        alert("Passwords do not match!");
        return false;
    }
    return true;
}

// Function to toggle password visibility
function togglePassword() {
    let passwordField = document.getElementById("password");
    let confirmPasswordField = document.getElementById("confirmPassword");
    let toggleText = document.getElementById("togglePasswordText");

    if (passwordField.type === "password") {
        passwordField.type = "text";
        confirmPasswordField.type = "text";
        toggleText.innerText = "Hide Password";
    } else {
        passwordField.type = "password";
        confirmPasswordField.type = "password";
        toggleText.innerText = "Show Password";
    }
}

// Attach event listener on page load
document.addEventListener("DOMContentLoaded", function () {
    let registerForm = document.getElementById("registerForm");
    if (registerForm) {
        registerForm.addEventListener("submit", function (event) {
            if (!validateRegisterForm()) {
                event.preventDefault(); // Prevent form submission if validation fails
            }
        });
    }
});
