package HomeWork;

public class InvalidCommandException extends Exception{
    public InvalidCommandException(String msg){
        super("InvalidCommandException: "+msg);
    }
}
