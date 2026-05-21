public class Switch{
    public static void main(String[] args){
        String signal="red";
        switch(signal)
        {
            case "red":
                System.out.println("stop");
                break;
            case "yellow":
                System.out.println("ready");
                break;
            case "green":
                System.out.println("go");
                break;
            default:
               System.out.println("Invalid Signal");
              
        }
        
    }
}