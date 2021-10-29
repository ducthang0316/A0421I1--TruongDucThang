package exam.util;

public class NotFoundProductException extends Exception{
    public NotFoundProductException(){}

    public NotFoundProductException(String msg){
        super(msg);
    }
}
