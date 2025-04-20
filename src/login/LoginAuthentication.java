package login;

import Database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAuthentication {
    public static String authenticateUser(String userId, String password) {
        String userType = null;
        String query = "SELECT user_type FROM users WHERE user_id = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, userId);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    userType = rs.getString("user_type");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userType;
    }
}