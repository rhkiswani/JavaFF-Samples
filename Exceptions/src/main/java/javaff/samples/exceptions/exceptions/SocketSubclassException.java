package javaff.samples.exceptions.exceptions;

public class SocketSubclassException extends SocketException{

    public SocketSubclassException(String message) {
        super(message);
    }

    public SocketSubclassException(String message, Object... errorMsgParams) {
        super(message, errorMsgParams);
    }

    public SocketSubclassException(String message, Throwable cause) {
        super(message, cause);
    }

    public SocketSubclassException(Throwable cause) {
        super(cause);
    }
}
