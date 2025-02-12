package com.sourabh.employee_management_system.controllers;

import com.sourabh.employee_management_system.dto.SkillSetDTO;
import com.sourabh.employee_management_system.entities.SkillSet;
import com.sourabh.employee_management_system.services.SkillSetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skills")
@Slf4j
public class SkillSetController {

    @Autowired
    private SkillSetService skillSetService;

    // Add a new skill
    @PostMapping
    public ResponseEntity<SkillSet> addSkill(@RequestBody SkillSetDTO skillDTO) {
        SkillSet skill = skillSetService.addSkill(skillDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(skill);
    }

    // Get all skills
    @GetMapping
    public ResponseEntity<List<SkillSet>> getAllSkills() {
        return ResponseEntity.ok(skillSetService.getAllSkills());
    }

    // Get a skill by ID
    @GetMapping("/{id}")
    public ResponseEntity<SkillSet> getSkillById(@PathVariable Long id) {
        return ResponseEntity.ok(skillSetService.getSkillById(id));
    }

    // Update a skill
    @PutMapping("/{id}")
    public ResponseEntity<SkillSet> updateSkill(@PathVariable Long id,@RequestBody SkillSetDTO skillSetDTO) {
        SkillSet updatedSkill = skillSetService.updateSkill(id, skillSetDTO);
        return ResponseEntity.ok(updatedSkill);
    }

    // Delete a skill
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSkill(@PathVariable Long id) {
        skillSetService.deleteSkill(id);
        return ResponseEntity.ok("Skill deleted successfully");
    }
}
