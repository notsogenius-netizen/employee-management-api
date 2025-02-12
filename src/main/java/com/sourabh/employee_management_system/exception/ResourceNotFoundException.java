package com.sourabh.employee_management_system.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApplicationException{
    public ResourceNotFoundException(String message, HttpStatus statusCode){
        super(message, statusCode);
    }
}
