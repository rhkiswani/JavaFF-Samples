package javaff.samples.exceptions.handlers;

import io.github.rhkiswani.javaff.exceptions.ExceptionHandler;

public class MailExceptionHandler implements ExceptionHandler {

    public void handle(Throwable t) {
        System.out.println("MailException handler");
    }
}
