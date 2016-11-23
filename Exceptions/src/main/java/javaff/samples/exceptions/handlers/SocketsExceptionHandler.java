package javaff.samples.exceptions.handlers;

import io.github.rhkiswani.javaff.exceptions.ExceptionHandler;

public class SocketsExceptionHandler implements ExceptionHandler {

    public void handle(Throwable t) {
        System.out.println("ConsoleException handler");
    }
}
