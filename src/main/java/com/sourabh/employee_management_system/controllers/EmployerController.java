package com.sourabh.employee_management_system.controllers;

import com.sourabh.employee_management_system.entities.Employer;
import com.sourabh.employee_management_system.services.EmployerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employers")
@Slf4j
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @PostMapping
    public ResponseEntity<Employer> addEmployer( @RequestBody Employer employer) {
        return ResponseEntity.ok(employerService.addEmployer(employer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employer> updateEmployer(@PathVariable Long id, @RequestBody Employer employer) {
        return ResponseEntity.ok(employerService.updateEmployer(id, employer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployer(@PathVariable Long id) {
        employerService.deleteEmployer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employer> getEmployerById(@PathVariable Long id) {
        return ResponseEntity.ok(employerService.getEmployerById(id));
    }
}
