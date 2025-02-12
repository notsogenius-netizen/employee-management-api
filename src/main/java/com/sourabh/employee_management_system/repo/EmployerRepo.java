package com.sourabh.employee_management_system.repo;

import com.sourabh.employee_management_system.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepo extends JpaRepository<Employer, Long> {
}
