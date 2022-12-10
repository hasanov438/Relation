package com.example.demo.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorMessage {
    private int statusCode;
    private LocalDate timestamp;
    private String message;
    private String description;
}
