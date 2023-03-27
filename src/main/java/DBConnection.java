import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/YOUR_DATABASE_NAME";
        String user = "postgres";
        String password = "Pokemon98";
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
