class ATM{
    //Private Data
    private int balance=5000;
    //Setter Method
    public void deposit(int amount){
        balance=balance+amount;
    }
    public int getbalance(){
        return balance;
    }
}
public class Encap{
    public static void main(String[] args){
        ATM obj=new ATM();
        obj.deposit(2000);
        System.out.println("Balance is:"+obj.getbalance());
    }


}