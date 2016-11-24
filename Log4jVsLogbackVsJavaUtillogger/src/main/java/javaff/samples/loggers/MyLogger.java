package javaff.samples.loggers;

import io.github.rhkiswani.javaff.log.Log;

public class MyLogger implements Log{

    public void debug(String message, Object... params) {
        System.out.println(message);
    }

    public void info(String message, Object... params) {
        System.out.println(message);
    }

    public void warn(String message, Object... params) {
        System.out.println(message);
    }

    public void error(String message, Object... params) {
        System.out.println(message);
    }

    public void error(String message, Exception e, Object... params) {
        System.out.println(message);
    }
}
