class Employee{
    String name;
    Employee(String n){
        name=n;
    }
    void display(){
        System.out.println(name);
    }
}
public class HN{
    
public static void main(String[] args){
    Employee e1=new Employee("preetham");
    e1.display();}}