package dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;
import util.DBConnection;


public class UserDAO {

    // ✅ Method 1: Register a New User
    public boolean registerUser(User user) {
        boolean isRegistered = false;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword()); // Later, encrypt password
            ps.setString(3, user.getRole());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                isRegistered = true;
                System.out.println("✅ User Registered Successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRegistered;
    }

    // ✅ Method 2: Validate User Login
    public User validateUser(String username, String password) {
        User user = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role")
                );
                System.out.println("✅ User Found: " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "SELECT * FROM users";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            users.add(new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("role")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return users;
}
    
    // ✅ Get User by ID
public User getUserById(int userId) {
    User user = null;
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "SELECT * FROM users WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            user = new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("role")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return user;
}

// ✅ Update User
public boolean updateUser(User user) {
    boolean isUpdated = false;
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "UPDATE users SET username = ?, role = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getRole());
        ps.setInt(3, user.getId());

        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0) {
            isUpdated = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return isUpdated;
}

// ✅ Delete User
public boolean deleteUser(int userId) {
    boolean isDeleted = false;
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "DELETE FROM users WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, userId);

        int rowsDeleted = ps.executeUpdate();
        if (rowsDeleted > 0) {
            isDeleted = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return isDeleted;
}


}
