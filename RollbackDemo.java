import java.sql.*;
public class RollbackDemo {
    public static void main(String args[]){
        String url = "jdbc:mysql://localhost:3306/student_id";
        String user = "root";
        String password = "cec123";
            Connection conn=null;
             try {
                conn=DriverManager.getConnection(url,user,password);
                conn.setAutoCommit(false);
                Statement stmt=conn.createStatement();
                stmt.executeUpdate(
                    "update accounts set balance= balance-500 where id=1"
                );
                 stmt.executeUpdate(
                    "update accounts set  balance=balance+500 where id=2"
                 );
                 conn.commit();
                 System.out.println("Transaction Successful");
                }
                catch(SQLException e){
                    try{
                        if(conn!=null){
                        conn.rollback();
                    }
                        System.out.println("Transaction Rolled Back");
                    }
                   catch(SQLException ex){ 
                    System.out.println("Rollback Failed");
                }
            }
        }
    }