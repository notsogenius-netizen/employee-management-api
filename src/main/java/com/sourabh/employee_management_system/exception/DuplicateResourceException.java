package com.sourabh.employee_management_system.exception;

import org.springframework.http.HttpStatus;

public class DuplicateResourceException extends ApplicationException{
    public DuplicateResourceException(String message, HttpStatus statusCode){
        super(message, statusCode);
    }
}
