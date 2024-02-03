package com.ems.employee_service.api.annotations.validators;

import com.ems.employee_service.api.annotations.validators.implementations.ValidMaritalStatusValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValidMaritalStatusValidator.class})
@Documented
public @interface ValidMaritalStatus {
    String message() default "Invalid marital status";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
