package pkg43_koltsegvetes.exception;

public class KoltsegvetesException extends Exception{

    public KoltsegvetesException() {
    }

    public KoltsegvetesException(String message) {
        super(message);
    }

    public KoltsegvetesException(String message, Throwable cause) {
        super(message, cause);
    }

    public KoltsegvetesException(Throwable cause) {
        super(cause);
    }

}
