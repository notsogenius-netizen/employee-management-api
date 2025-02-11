package com.sourabh.employee_management_system.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String industry;

    private String email;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Project> projects = new HashSet<>();
}
