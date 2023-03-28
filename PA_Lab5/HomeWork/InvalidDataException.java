package HomeWork;

public class InvalidDataException extends Exception{
    public InvalidDataException(String msg){
        super("InvalidDataException: "+ msg);
    }
}
