package com.ems.employee_service.api.annotations.validators.implementations;

import com.ems.employee_service.api.annotations.validators.ValidMaritalStatus;
import com.ems.employee_service.persistence.enums.MaritalStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidMaritalStatusValidator implements ConstraintValidator<ValidMaritalStatus, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        for (MaritalStatus maritalStatus : MaritalStatus.values()) {
            if (maritalStatus.getMaritalStatus().equals(value)) {
                return true;
            }
        }

        return false;
    }
}
