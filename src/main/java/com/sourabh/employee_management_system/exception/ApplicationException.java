package com.sourabh.employee_management_system.exception;

public class ApplicationException extends RuntimeException{
    private int statusCode;
    public ApplicationException(String message, int statusCode){
        super(message);
        this.statusCode = statusCode;
    }
}
