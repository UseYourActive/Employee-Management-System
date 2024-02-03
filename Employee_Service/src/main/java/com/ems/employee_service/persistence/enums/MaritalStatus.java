package com.ems.employee_service.persistence.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MaritalStatus {
    DIVORCED("Divorced"),
    SEPARATED("Separated"),
    SINGLE("Single"),
    MARRIED("Married"),
    WIDOWED("Widowed");

    private final String maritalStatus;
}
