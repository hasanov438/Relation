package com.example.demo.exception;

public class NoSuchElementException extends RuntimeException {
    private String message;

    public NoSuchElementException(String message) {
        super(message);
        this.message = message;
    }

}


