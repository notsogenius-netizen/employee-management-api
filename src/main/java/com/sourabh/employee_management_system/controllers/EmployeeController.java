package com.sourabh.employee_management_system.controllers;

import com.sourabh.employee_management_system.entities.Employee;
import com.sourabh.employee_management_system.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.addEmployee(employee));
    }

    @GetMapping
    private ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
    }


}
