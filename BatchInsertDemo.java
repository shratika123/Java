import java.sql.*;

public class BatchInsertDemo {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/school_db";
        String user = "root";
        String pass = "cec123";

        try {
            // 1. Create DB connection
            Connection conn =
                    DriverManager.getConnection(url, user, pass);

            // 2. SQL query
            String sql =
                    "INSERT INTO students(name, grade) VALUES (?, ?)";

            // 3. Create PreparedStatement
            PreparedStatement pstmt =
                    conn.prepareStatement(sql);

            // 4. Loop runs 100 times
            for (int i = 1; i <= 100; i++) {

                // Set student name
                pstmt.setString(1, "Student" + i);

                // Set marks
                pstmt.setDouble(2, 60 + i * 0.3);

                // Add query to batch
                pstmt.addBatch();
            }

            // 5. Execute all queries together
            int[] results = pstmt.executeBatch();

            // 6. Print total inserted rows
            System.out.println(
                    results.length +
                    " rows inserted successfully!"
            );

            // 7. Close connection
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}