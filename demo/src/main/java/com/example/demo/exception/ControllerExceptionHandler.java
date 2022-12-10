package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.time.LocalDate;

@RestControllerAdvice
public class ControllerExceptionHandler extends RuntimeException {
    @ExceptionHandler(NoSuchEmployeeExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage noSuchEmployeeExitsException(NoSuchEmployeeExistsException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), LocalDate.now(), ex.getMessage(), "No employee exist");
        return errorMessage;
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorMessage noSuchElementExitsException(NoSuchElementException ex) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), LocalDate.now(), ex.getMessage(), "No such element  exist");
        return errorMessage;
    }

    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage EmployeeAlreadyExistException(EmployeeAlreadyExistsException exception) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), LocalDate.now(), exception.getMessage(), "Employee already exist ");
        return errorMessage;
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ErrorMessage> handleSizeExceededException(MaxUploadSizeExceededException e) {
        return new ResponseEntity<>(new ErrorMessage(HttpStatus.BAD_REQUEST.value(), LocalDate.now(), e.getMessage(), "exceed max upload file size"), HttpStatus.EXPECTATION_FAILED);
    }
}

