package javaff.samples.exceptions.exceptions;

import io.github.rhkiswani.javaff.exceptions.SmartException;

public class SocketException extends SmartException{

    public SocketException(String message) {
        super(message);
    }

    public SocketException(String message, Object... errorMsgParams) {
        super(message, errorMsgParams);
    }

    public SocketException(String message, Throwable cause) {
        super(message, cause);
    }

    public SocketException(Throwable cause) {
        super(cause);
    }
}
