import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static final String URL =
            "jdbc:mysql://localhost:3306/movie";

    static final String USER = "root";

    // XAMPP default password is empty
    static final String PASSWORD = "";

    public static Connection getConnection() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database Connected Successfully!");

        } catch (Exception e) {

            System.out.println("Connection Error");
            System.out.println(e);
        }

        return conn;
    }
}