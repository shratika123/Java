import java.sql.*;

public class JDBCConnectionTest {
    public static void main(String[] args) {
        String url      = "jdbc:mysql://localhost:3306";
        String user     = "root";
        String password = "cec123";
        System.out.println("Connecting to MySQL...");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("✅ Connection Successful!");
                System.out.println("Database : " + conn.getCatalog());
                System.out.println("Driver   : " + conn.getMetaData().getDriverName());
            }
        } catch (SQLException e) {
            System.out.println("❌ Connection Failed!");
            System.out.println("Error: " + e.getMessage());
        }
    }
}