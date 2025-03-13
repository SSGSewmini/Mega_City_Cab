package Testpackages;

import dao.UserDAO;
import model.User;

public class UserDAOTest {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Register a new user
        User newUser = new User(0, "john_doe", "password123", "customer");
        boolean isRegistered = userDAO.registerUser(newUser);
        System.out.println("User Registration: " + isRegistered);

        // Validate user login
        User loginUser = userDAO.validateUser("john_doe", "password123");
        if (loginUser != null) {
            System.out.println("Login Successful! Welcome " + loginUser.getUsername());
        } else {
            System.out.println("Invalid Username or Password!");
        }
    }
}
