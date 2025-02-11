package com.sourabh.employee_management_system.services;

import com.sourabh.employee_management_system.dto.SkillSetDTO;
import com.sourabh.employee_management_system.entities.SkillSet;
import com.sourabh.employee_management_system.exception.DuplicateResourceException;
import com.sourabh.employee_management_system.exception.ResourceNotFoundException;
import com.sourabh.employee_management_system.repo.SkillSetRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SkillSetService {

    @Autowired
    private SkillSetRepo skillSetRepo;

    //  Add a new Skill
    public SkillSet addSkill(SkillSetDTO skillDTO) {
        if (skillSetRepo.findByName(skillDTO.getName()).isPresent()) {
            throw new DuplicateResourceException("Skill already exists: " + skillDTO.getName(), HttpStatus.BAD_REQUEST);
        }
        SkillSet skill = new SkillSet();
        skill.setName(skillDTO.getName());
        return skillSetRepo.save(skill);
    }

    // Get all Skills
    public List<SkillSet> getAllSkills() {
        return skillSetRepo.findAll();
    }

    // Get a Skill by ID
    public SkillSet getSkillById(Long id) {
        return skillSetRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found with ID: " + id, HttpStatus.NOT_FOUND));
    }

    // Update a Skill
    public SkillSet updateSkill(Long id, SkillSetDTO skillDTO) {
        SkillSet skill = skillSetRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found with ID: " + id, HttpStatus.NOT_FOUND));

        skill.setName(skillDTO.getName());
        return skillSetRepo.save(skill);
    }

    // Delete a Skill
    public void deleteSkill(Long id) {
        SkillSet skill = skillSetRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill not found with ID: " + id, HttpStatus.NOT_FOUND));

        skillSetRepo.delete(skill);
    }
}

