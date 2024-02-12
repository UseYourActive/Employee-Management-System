package com.ems.employee_service.persistence.entities.ideas.expensemanagement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

//@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private String category;
    private BigDecimal amount;
    private LocalDate expenseDate;
    private String description;

    // Getters and setters
}
