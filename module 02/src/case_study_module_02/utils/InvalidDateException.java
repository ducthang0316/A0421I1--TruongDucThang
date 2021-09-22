package case_study_module_02.utils;

public class InvalidDateException extends Exception{
    public InvalidDateException(){}

    public InvalidDateException (String message){
        super(message);
    }
}
