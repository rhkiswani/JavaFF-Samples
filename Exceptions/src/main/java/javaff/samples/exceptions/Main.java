package javaff.samples.exceptions;

import io.github.rhkiswani.javaff.exceptions.ExceptionHandlersFactory;
import io.github.rhkiswani.javaff.exceptions.ExceptionUtil;
import io.github.rhkiswani.javaff.exceptions.SmartException;
import javaff.samples.exceptions.exceptions.MailException;
import javaff.samples.exceptions.exceptions.MailSubclassException;
import javaff.samples.exceptions.exceptions.SocketException;
import javaff.samples.exceptions.exceptions.SocketSubclassException;
import javaff.samples.exceptions.handlers.AllExceptionHandler;
import javaff.samples.exceptions.handlers.MailExceptionHandler;
import javaff.samples.exceptions.handlers.NewThrowableExceptionHandler;
import javaff.samples.exceptions.handlers.SocketsExceptionHandler;

public class Main {

    public static void main(String[] args) {

        // here all the exception will be handled by the default implantation which is printing stack trace
        testHandle();

        // here any instance from SocketException will be handled by SocketsExceptionHandler
        // any instance from MailException will be handled by MailExceptionHandler
        // any instance from Throwable will be handled by NewThrowableExceptionHandler
        regHandlersPerType();
        testHandle();

        // All exceptions will be handled by AllExceptionHandler
        setDefaultHandler();
        testHandle();
    }

    private static void setDefaultHandler() {
        ExceptionHandlersFactory.instance().overrideImp(Throwable.class, new AllExceptionHandler());
    }

    private static void regHandlersPerType() {
        //Any instance of ConsoleException will be handled here
        ExceptionHandlersFactory.instance().add(SocketException.class, new SocketsExceptionHandler());

        //Any instance of MailException will be handled here
        ExceptionHandlersFactory.instance().add(MailException.class, new MailExceptionHandler());

        //Any instance of Throwable will be handled here
        ExceptionHandlersFactory.instance().overrideImp(Throwable.class, new NewThrowableExceptionHandler());
    }

    private static void testHandle() {
        ExceptionUtil.handle(new SocketException(SmartException.EXCEEDS_LIMIT, "Sockets", 1000));
        ExceptionUtil.handle(new SocketSubclassException(SmartException.EXCEEDS_LIMIT, "Sockets", 1000));
        ExceptionUtil.handle(new MailException(SmartException.NOT_FOUND, "User"));
        ExceptionUtil.handle(new MailSubclassException(SmartException.NOT_FOUND, "User"));
        ExceptionUtil.handle(new NullPointerException());
    }

}
