package com.ems.employee_service.api.annotations.validators;

import com.ems.employee_service.api.annotations.validators.implementations.ValidGenderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValidGenderValidator.class})
@Documented
public @interface ValidGender {
    String message() default "Invalid gender";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

