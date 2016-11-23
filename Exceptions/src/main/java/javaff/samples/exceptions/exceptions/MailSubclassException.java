package javaff.samples.exceptions.exceptions;

public class MailSubclassException extends MailException{

    public MailSubclassException(String message) {
        super(message);
    }

    public MailSubclassException(String message, Object... errorMsgParams) {
        super(message, errorMsgParams);
    }

    public MailSubclassException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailSubclassException(Throwable cause) {
        super(cause);
    }
}
