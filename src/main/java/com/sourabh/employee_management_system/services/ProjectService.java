package com.sourabh.employee_management_system.services;

import com.sourabh.employee_management_system.dto.ProjectDTO;
import com.sourabh.employee_management_system.entities.Employer;
import com.sourabh.employee_management_system.entities.Project;
import com.sourabh.employee_management_system.exception.DuplicateResourceException;
import com.sourabh.employee_management_system.exception.ResourceNotFoundException;
import com.sourabh.employee_management_system.repo.EmployerRepo;
import com.sourabh.employee_management_system.repo.ProjectRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectService {

    private final ProjectRepo projectRepository;
    private final EmployerRepo employerRepository;

    // Add a new Project
    public Project addProject(ProjectDTO projectDTO) {
        if (projectRepository.findByName(projectDTO.getName()).isPresent()) {
            throw new DuplicateResourceException("Project already exists: " + projectDTO.getName(), HttpStatus.CONFLICT);
        }

        Employer employer = employerRepository.findById(projectDTO.getEmployerId())
                .orElseThrow(() -> new DuplicateResourceException("Employer not found with ID: " + projectDTO.getEmployerId(), HttpStatus.CONFLICT));

        Project project = Project.builder()
                .name(projectDTO.getName())
                .description(projectDTO.getDescription())
                .employer(employer)
                .build();

        return projectRepository.save(project);
    }

    // ✅ Get all Projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // ✅ Get a Project by ID
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + id, HttpStatus.NOT_FOUND));
    }

    // ✅ Update a Project
    public Project updateProject(Long id, ProjectDTO projectDTO) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + id, HttpStatus.NOT_FOUND));

        Employer employer = employerRepository.findById(projectDTO.getEmployerId())
                .orElseThrow(() -> new ResourceNotFoundException("Employer not found with ID: " + projectDTO.getEmployerId(), HttpStatus.NOT_FOUND));

        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setEmployer(employer);

        return projectRepository.save(project);
    }

    // ✅ Delete a Project
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + id, HttpStatus.NOT_FOUND));

        projectRepository.delete(project);
    }
}
