package com.ems.employee_service.persistence.entities.ideas.assetmanagement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private String assetType;
    private String assetName;
    private String serialNumber;
    private String status; // e.g., assigned, available, in maintenance

    // Getters and setters
}

//    Track company assets assigned to employees (e.g., laptops, phones).
//        Monitor asset status, maintenance, and generate asset-related reports.