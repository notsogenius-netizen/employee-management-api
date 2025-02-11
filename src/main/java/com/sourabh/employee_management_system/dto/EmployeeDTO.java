package com.sourabh.employee_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String name;
    private String email;
    private String role;
    private String department;
    private Set<Long> skills;  // Accept Skill IDs instead of objects
    private Set<Long> projects; // Accept Project IDs instead of objects
}
