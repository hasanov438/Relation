package com.example.demo.exception;


public class EmployeeAlreadyExistsException extends RuntimeException {
    private String messagge;

    public EmployeeAlreadyExistsException(String message) {
        super(message);
        this.messagge = message;
    }
}


