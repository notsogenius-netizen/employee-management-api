package com.sourabh.employee_management_system.repo;

import com.sourabh.employee_management_system.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
}
