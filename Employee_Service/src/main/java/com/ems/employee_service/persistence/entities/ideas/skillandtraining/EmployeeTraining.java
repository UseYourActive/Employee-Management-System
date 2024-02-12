package com.ems.employee_service.persistence.entities.ideas.skillandtraining;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

//@Entity
public class EmployeeTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private String trainingTitle;
    private String trainingDescription;
    private LocalDate startDate;
    private LocalDate endDate;

    // Getters and setters
}

//    public EmployeeTraining addTraining(Long employeeId, String trainingTitle, String trainingDescription,
//                                        LocalDate startDate, LocalDate endDate) {
//        EmployeeTraining employeeTraining = new EmployeeTraining();
//        employeeTraining.setEmployeeId(employeeId);
//        employeeTraining.setTrainingTitle(trainingTitle);
//        employeeTraining.setTrainingDescription(trainingDescription);
//        employeeTraining.setStartDate(startDate);
//        employeeTraining.setEndDate(endDate);
//        return employeeTrainingRepository.save(employeeTraining);
//    }