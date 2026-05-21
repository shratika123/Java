class LowBalanceException extends Exception{
    LowBalanceException(String message){
        super(message);
    }
}
public class CustomE{
    public static void main(String[] args){
        int balance=500;
    try{
        if(balance<100){
            throw new LowBalanceException("Balance is less than 1000");
        }
        System.out.println("Transaction Successful");
    }
        catch(LowBalanceException e){
            System.out.println(e.getMessage());
        }
    }
}