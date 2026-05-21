interface Animal{
    void sound();
}
class Dog implements Animal{
    public void sound(){
        System.out.println("Dog barks");
    }
    }
public class Main11{
    public static void main(String[] args){
        Dog obj=new Dog();
        obj.sound(); 
    }
}