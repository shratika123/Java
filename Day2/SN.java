class Student{ 
    String name;
    Student(String name){
        this.name=name;
    }
    void show(){
        System.out.println("Student name:"+name);
    }
}
public class SN{
    public static void main(String[] args){
    Student s1=new Student( "preetham");
    s1.show();
}}