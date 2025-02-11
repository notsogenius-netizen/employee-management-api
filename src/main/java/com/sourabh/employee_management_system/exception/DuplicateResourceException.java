package com.sourabh.employee_management_system.exception;

public class DuplicateResourceException extends ApplicationException{
    public DuplicateResourceException(String message, int statusCode){
        super(message, statusCode);
    }
}
