import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // ADD STUDENT
    public void addStudent(Student s) {

        try {

            // VALIDATION

            if(s.getName().isEmpty()) {

                System.out.println("Name cannot be empty");
                return;
            }

            if(!s.getEmail().contains("@")) {

                System.out.println("Invalid Email");
                return;
            }

            if(s.getAge() <= 0) {

                System.out.println("Age must be positive");
                return;
            }

            if(s.getCourse().isEmpty()) {

                System.out.println("Course cannot be empty");
                return;
            }

            Connection con = DBConnection.getConnection();

            if(con == null) {

                System.out.println("Database Connection Error");
                return;
            }

            String sql =
                "INSERT INTO students(name,email,course,age) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getAge());

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println("Student Added Successfully");

                writeLog("Student Added Successfully");
            }

        } catch(Exception e) {

            System.out.println("Error While Adding Student");

            System.out.println("Error Message: " + e.getMessage());

            e.printStackTrace();
        }
    }

    // VIEW STUDENTS
    public void viewStudents() {

        try {

            Connection con = DBConnection.getConnection();

            if(con == null) {

                System.out.println("Database Connection Error");
                return;
            }

            String sql = "SELECT * FROM students";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== STUDENT LIST =====");

            while(rs.next()) {

                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email") + " | " +
                    rs.getString("course") + " | " +
                    rs.getInt("age")
                );
            }

        } catch(Exception e) {

            System.out.println("Error While Viewing Students");

            System.out.println("Error Message: " + e.getMessage());

            e.printStackTrace();
        }
    }

    // UPDATE STUDENT
    public void updateStudent(Student s) {

        try {

            Connection con = DBConnection.getConnection();

            if(con == null) {

                System.out.println("Database Connection Error");
                return;
            }

            String sql =
                "UPDATE students SET name=?, email=?, course=?, age=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getAge());
            ps.setInt(5, s.getId());

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println("Student Updated Successfully");

                writeLog("Student Updated Successfully");

            } else {

                System.out.println("Student ID Not Found");
            }

        } catch(Exception e) {

            System.out.println("Error While Updating Student");

            System.out.println("Error Message: " + e.getMessage());

            e.printStackTrace();
        }
    }

    // DELETE STUDENT
    public void deleteStudent(int id) {

        try {

            Connection con = DBConnection.getConnection();

            if(con == null) {

                System.out.println("Database Connection Error");
                return;
            }

            String sql = "DELETE FROM students WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println("Student Deleted Successfully");

                writeLog("Student Deleted Successfully");

            } else {

                System.out.println("Student ID Not Found");
            }

        } catch(Exception e) {

            System.out.println("Error While Deleting Student");

            System.out.println("Error Message: " + e.getMessage());

            e.printStackTrace();
        }
    }

    // WRITE LOG
    public void writeLog(String message) {

        try {

            FileWriter writer =
                new FileWriter("logs/application.log", true);

            writer.write(message + "\n");

            writer.close();

        } catch(Exception e) {

            System.out.println("Logging Error");

            System.out.println(e.getMessage());
        }
    }
}