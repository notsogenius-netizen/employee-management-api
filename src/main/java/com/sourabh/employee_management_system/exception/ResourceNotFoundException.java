package com.sourabh.employee_management_system.exception;

public class ResourceNotFoundException extends ApplicationException{
    public ResourceNotFoundException(String message, int statusCode){
        super(message, statusCode);
    }
}
