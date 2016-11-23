package javaff.samples.exceptions.exceptions;

import io.github.rhkiswani.javaff.exceptions.SmartException;

public class MailException extends SmartException{

    public MailException(String message) {
        super(message);
    }

    public MailException(String message, Object... errorMsgParams) {
        super(message, errorMsgParams);
    }

    public MailException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailException(Throwable cause) {
        super(cause);
    }
}
