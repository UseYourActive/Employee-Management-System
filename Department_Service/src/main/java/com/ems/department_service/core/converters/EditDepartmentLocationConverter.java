package com.ems.department_service.core.converters;

import com.ems.department_service.api.operations.edit.location.EditDepartmentLocationResponse;
import com.ems.department_service.persistence.entities.Department;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EditDepartmentLocationConverter implements Converter<Department, EditDepartmentLocationResponse> {
    @Override
    public EditDepartmentLocationResponse convert(Department source) {
        return EditDepartmentLocationResponse.builder()
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
