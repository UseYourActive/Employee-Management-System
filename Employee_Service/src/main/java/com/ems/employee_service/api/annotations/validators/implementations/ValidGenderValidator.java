package com.ems.employee_service.api.annotations.validators.implementations;

import com.ems.employee_service.api.annotations.validators.ValidGender;
import com.ems.employee_service.persistence.enums.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidGenderValidator implements ConstraintValidator<ValidGender, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        for (Gender gender : Gender.values()) {
            if (gender.getGender().equals(value)) {
                return true;
            }
        }

        return false;
    }
}
