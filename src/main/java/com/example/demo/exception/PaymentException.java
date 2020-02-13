package com.example.demo.exception;

public class PaymentException extends OrderException {

    public PaymentException(String message) {
        super(message);
    }

    public PaymentException(String message, Throwable e) {
        super(message, e);
    }
}
