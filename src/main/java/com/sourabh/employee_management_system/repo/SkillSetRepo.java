package com.sourabh.employee_management_system.repo;

import com.sourabh.employee_management_system.entities.SkillSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillSetRepo extends JpaRepository<SkillSet, Long> {
    Optional<SkillSet> findByName(String name);
}
