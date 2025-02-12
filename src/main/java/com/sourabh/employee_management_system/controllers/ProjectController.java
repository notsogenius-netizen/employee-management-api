package com.sourabh.employee_management_system.controllers;

import com.sourabh.employee_management_system.dto.ProjectDTO;
import com.sourabh.employee_management_system.entities.Project;
import com.sourabh.employee_management_system.services.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // ✅ Add a new project
    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody ProjectDTO projectDTO) {
        Project project = projectService.addProject(projectDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    // ✅ Get all projects
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    // ✅ Get a project by ID
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    // ✅ Update a project
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody ProjectDTO project){
        return ResponseEntity.ok(projectService.updateProject(id, project));
    }
}

