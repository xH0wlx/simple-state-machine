package com.example.demo.exception;

public class ProcessException extends Exception {

    public ProcessException(String message) {
        super(message);
    }

    public ProcessException(String message, Throwable e) {
        super(message, e);
    }
}
