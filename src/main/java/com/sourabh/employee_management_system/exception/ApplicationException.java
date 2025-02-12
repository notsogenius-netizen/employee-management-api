package com.sourabh.employee_management_system.exception;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException{
    private HttpStatus statusCode;
    public ApplicationException(String message, HttpStatus statusCode){
        super(message);
        this.statusCode = statusCode;
    }
}
