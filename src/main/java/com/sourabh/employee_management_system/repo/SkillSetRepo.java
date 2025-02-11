package com.sourabh.employee_management_system.repo;

import com.sourabh.employee_management_system.entities.SkillSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillSetRepo extends JpaRepository<SkillSet, Long> {
}
