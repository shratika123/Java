class Grandfather{
    void land(){
        System.out.println("Grandfather has land");
    }
}
class Father extends Grandfather{
    void bike(){
         System.out.println("Father has bike");
    }
}
class Son extends Father{
    void laptop(){
        System.out.println("Son has laptop");
    }
}
public class Mui{
    public static void main(String[] args){
        Son s=new Son();
       s.land();
       s.bike();
        s.laptop();
    }
}