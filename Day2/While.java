public class While{
    public static void main(String[] args){
        int password=1234;
        int enteredpin=1111;
        while(enteredpin!=password){
     System.out.println("Wrong pin try again");
    enteredpin++;
    }
    System.out.println("Correct pin entered");
    }
}

