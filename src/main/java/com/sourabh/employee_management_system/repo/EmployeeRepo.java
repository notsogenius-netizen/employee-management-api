package com.sourabh.employee_management_system.repo;

import com.sourabh.employee_management_system.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
