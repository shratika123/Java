import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;



public class StudentCRUD {
    static final String URL = "jdbc:mysql://localhost:3306/school_db";
    static final String USER ="root",PASSWORD="cec123";
    static void insertStudent(String name,int age,double grade){
        String sql = "INSERT INTO student(name,age,grade) VALUES(?,?,?)";
        try(Connection conn =DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,name);
            pstmt.setInt(2,age);
            pstmt.setDouble(3,grade);
            int rows = pstmt.executeUpdate();
            System.out.println("Inserted"+rows+"student:"+name);
        }catch(SQLException e){
            System.out.println("Error:"+e.getMessage());
            }
        }
        static void getAllStudents(){
            try(Connection conn =DriverManager.getConnection(URL,USER,PASSWORD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM student")){
                while(rs.next()){
                    System.out.printf("ID=%-3d Name=%-15s Grade=%.1f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("grade"));
                }
            }catch(SQLException e){
                System.out.println("Error:"+e.getMessage());
            }
        }
        static void updateMarks(int id,double newgrade){
            String sql="UPDATE student SET grade=? WHERE id=?";
            try(Connection conn =DriverManager.getConnection(URL,USER,PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setDouble(1,newgrade);
                pstmt.setInt(2,id);
                System.out.println("Updated"+pstmt.executeUpdate()+"row(s)");
            }catch(SQLException e){
                System.out.println("Error:"+e.getMessage());
            }
        }   
        static void deleteStudent(int id){
            String sql="DELETE FROM student WHERE id=?";
            try(Connection conn =DriverManager.getConnection(URL,USER,PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1,id);
                System.out.println("Deleted"+pstmt.executeUpdate()+"row(s)");
            }catch(SQLException e){
                System.out.println("Error:"+e.getMessage());
            }
        }      
           public static void main(String args[]){
        insertStudent("Shratika",19,90.0);
        
        System.out.println("All Students:");
        getAllStudents();
        updateMarks(14,95.0);
        System.out.println("After Update:");
        getAllStudents();
        deleteStudent(12);
       
        System.out.println("After Deletion:");
        getAllStudents();
    }
}