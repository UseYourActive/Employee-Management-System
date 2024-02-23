package com.ems.user_authentication_service.api.annotations.validators.implementations;

import com.ems.user_authentication_service.api.annotations.validators.StrongPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            return false;
        }

        // At least 8 characters
        if (password.length() < 8) {
            return false;
        }

        // At least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // At least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // At least one digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // At least one special character
        if (!password.matches(".*[!@#$%^&*()-_=+\\\\|[{]};:'\",<.>/?].*")) {
            return false;
        }

        return true;
    }
}
