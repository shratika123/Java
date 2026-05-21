abstract class Vehicle{
    abstract void move();
    void start(){
        System .out.println("Vehicle is starting");

    }
}
class Car extends Vehicle{
    void move(){
        System.out.println("car moves on road");
    }
}
public class Abstract{
    public static void main(String[] args){
        Car obj=new Car();
        obj.start();
        obj.move();
    }
}