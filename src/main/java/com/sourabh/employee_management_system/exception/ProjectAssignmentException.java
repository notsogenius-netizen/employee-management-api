package com.sourabh.employee_management_system.exception;

import org.springframework.http.HttpStatus;

public class ProjectAssignmentException extends ApplicationException{
    public ProjectAssignmentException(String message, HttpStatus statusCode){
        super(message, statusCode);
    }
}
