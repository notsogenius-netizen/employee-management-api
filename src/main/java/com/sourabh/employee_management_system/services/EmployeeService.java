package com.sourabh.employee_management_system.services;

import com.sourabh.employee_management_system.dto.EmployeeDTO;
import com.sourabh.employee_management_system.entities.Employee;
import com.sourabh.employee_management_system.entities.Project;
import com.sourabh.employee_management_system.entities.SkillSet;
import com.sourabh.employee_management_system.exception.ApplicationException;
import com.sourabh.employee_management_system.exception.ResourceNotFoundException;
import com.sourabh.employee_management_system.repo.EmployeeRepo;
import com.sourabh.employee_management_system.repo.ProjectRepo;
import com.sourabh.employee_management_system.repo.SkillSetRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private SkillSetRepo skillSetRepo;

    @Autowired
    private ProjectRepo projectRepo;

    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setRole(employeeDTO.getRole());
        employee.setDepartment(employeeDTO.getDepartment());

        // Fetch skills from database
        Set<SkillSet> skills = employeeDTO.getSkills().stream()
                .map(skillId -> skillSetRepo.findById(skillId)
                        .orElseThrow(() -> new ResourceNotFoundException("Skill not found with ID: " + skillId, HttpStatus.NOT_FOUND)))
                .collect(Collectors.toSet());

        // ✅ Fetch projects from database instead of directly assigning IDs
        Set<Project> projects = employeeDTO.getProjects().stream()
                .map(projectId -> projectRepo.findById(projectId)
                        .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + projectId,HttpStatus.NOT_FOUND)))
                .collect(Collectors.toSet());

        employee.setSkills(skills);
        employee.setProjects(projects);

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

    public void deleteEmployee(Long id){
        employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found", HttpStatus.NOT_FOUND));
        employeeRepo.deleteById(id);
    }

    public Employee getEmployeeById(Long id){
        return employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found", HttpStatus.NOT_FOUND));
    }

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
}
