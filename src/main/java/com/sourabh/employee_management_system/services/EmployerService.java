package com.sourabh.employee_management_system.services;

import com.sourabh.employee_management_system.entities.Employer;
import com.sourabh.employee_management_system.exception.ResourceNotFoundException;
import com.sourabh.employee_management_system.repo.EmployerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployerService {

    @Autowired
    private EmployerRepo employerRepository;

    public Employer addEmployer(Employer employer) {
        log.info("Adding a new employer: {}", employer);
        return employerRepository.save(employer);
    }

    public Employer updateEmployer(Long id, Employer employer) {
        Employer existing = employerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employer not found", HttpStatus.NOT_FOUND));

        existing.setName(employer.getName());
        existing.setIndustry(employer.getIndustry());
        existing.setEmail(employer.getEmail());

        return employerRepository.save(existing);
    }

    public void deleteEmployer(Long id) {
        employerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employer not found", HttpStatus.NOT_FOUND));
        employerRepository.deleteById(id);
    }

    public Employer getEmployerById(Long id) {
        return employerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employer not found", HttpStatus.NOT_FOUND));
    }
}

