package javaff.samples.exceptions.handlers;

import io.github.rhkiswani.javaff.exceptions.ExceptionHandler;

public class NewThrowableExceptionHandler implements ExceptionHandler {

    public void handle(Throwable t) {
        System.out.println("Throwable overridden handler");
    }
}
