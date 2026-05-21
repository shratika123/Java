import java.io.FileWriter;

public class File1 {
    public static void main(String[] args) {
        try {
            FileWriter fw=new FileWriter("marks.txt");
            fw.write("Preetham:85");
            fw.write("Rajashri:90");
            fw.close();
            System.out.println("Data written successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
        
    } 
}