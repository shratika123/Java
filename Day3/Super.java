class Vehicle{
    String color="Red";
    Vehicle(){
        System.out.println("Vehicle constructor called");
    }
void display(){
    System.out.println("This is vehicle class");
}}
class Car extends Vehicle{
    String color="Pink";
    Car(){
        super();
        System.out.println("car constructor called");

    }

void show(){
    System.out.println("parent colour:"+super.color);
    super.display();
    
    System.out.println("child colour:"+color);
}}
public class Super{
    public static void main(String[] args)
    {
        Car c=new Car();
        c.show();
    }
}
