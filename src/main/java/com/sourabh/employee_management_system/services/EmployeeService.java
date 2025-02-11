package com.sourabh.employee_management_system.services;

import com.sourabh.employee_management_system.entities.Employee;
import com.sourabh.employee_management_system.exception.ResourceNotFoundException;
import com.sourabh.employee_management_system.repo.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee){
        Employee existingEmployee  = employeeRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found", HttpStatus.NOT_FOUND));
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setRole(employee.getRole());
        existingEmployee.setDepartment(employee.getDepartment());

        return employeeRepo.save(existingEmployee);
    }
}
