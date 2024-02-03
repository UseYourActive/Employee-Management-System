package com.ems.employee_service.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Department {
    HUMAN_RESOURCES("Human resources"),
    MARKETING("Marketing"),
    FINANCE("Finance"),
    HEALTH_CARE("Health care"),
    IT("IT");

    private final String department;
}
