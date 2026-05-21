class Bankaccount{
    private int pin = 1234;
    void showPin(){
        System.out.println("PIN inside a class:"+pin);
    }
} public class Main{
    public static void main(String[] args){
    Bankaccount b=new Bankaccount();
    b.showPin();
}}