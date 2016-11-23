package javaff.samples.exceptions.handlers;

import io.github.rhkiswani.javaff.exceptions.ExceptionHandler;

public class AllExceptionHandler implements ExceptionHandler {

    public void handle(Throwable t) {
        System.out.println("AllException handler");
    }
}
