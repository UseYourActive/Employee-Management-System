package com.ems.department_service.core.converters;

import com.ems.department_service.api.operations.edit.phone_number.EditDepartmentPhoneNumberResponse;
import com.ems.department_service.persistence.entities.Department;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EditDepartmentPhoneNumberConverter implements Converter<Department, EditDepartmentPhoneNumberResponse> {
    @Override
    public EditDepartmentPhoneNumberResponse convert(Department source) {
        return EditDepartmentPhoneNumberResponse.builder()
                .id(String.valueOf(source.getId()))
                .name(source.getName())
                .location(source.getLocation())
                .email(source.getEmail())
                .budget(String.valueOf(source.getBudget()))
                .description(source.getDescription())
                .phoneNumber(source.getPhoneNumber())
                .build();
    }
}
