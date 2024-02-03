package com.ems.employee_service.persistence.entities.ideas.skillandtraining;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private String skillName;
    private String proficiencyLevel;

    // Getters and setters
}

//    public EmployeeSkill addSkill(Long employeeId, String skillName, String proficiencyLevel) {
//        EmployeeSkill employeeSkill = new EmployeeSkill();
//        employeeSkill.setEmployeeId(employeeId);
//        employeeSkill.setSkillName(skillName);
//        employeeSkill.setProficiencyLevel(proficiencyLevel);
//        return employeeSkillRepository.save(employeeSkill);
//    }
