package com.ems.employee_service.persistence.entities.ideas.performance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private String evaluator;
    private LocalDate evaluationDate;
    private String goals;
    private String feedback;

    // Getters and setters
}

//    Implement a system for employee performance evaluations.
//        Allow managers to set goals, provide feedback, and conduct performance reviews.
//        Generate performance reports and analytics.