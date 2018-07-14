package com.akos.libraryapp.services;

public class OrderProcessingException extends RuntimeException {

    public OrderProcessingException() {
    }

    public OrderProcessingException(String message) {
        super(message);
    }

    public OrderProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
