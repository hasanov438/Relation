package com.example.demo.exception;


public class NoSuchEmployeeExistsException extends RuntimeException {
    private final String message;

    public NoSuchEmployeeExistsException(String message) {
        super(message);
        this.message = message;
    }
}


