import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/USER_CREDENTIALS";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Pokemon98";

    public static boolean validateUser(String username, String password) {
        boolean isValid = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            isValid = rs.next();
            rs.close();
            ps.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }
}
