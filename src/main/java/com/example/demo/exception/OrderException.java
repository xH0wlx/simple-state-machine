package com.example.demo.exception;


public class OrderException extends ProcessException {

    public OrderException(String message) {
        super(message);
    }

    public OrderException(String message, Throwable e) {
        super(message, e);
    }
}
