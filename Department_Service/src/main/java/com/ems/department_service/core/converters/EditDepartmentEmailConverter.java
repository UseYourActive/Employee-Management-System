package com.ems.department_service.core.converters;

import com.ems.department_service.api.operations.edit.email.EditDepartmentEmailResponse;
import com.ems.department_service.persistence.entities.Department;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EditDepartmentEmailConverter implements Converter<Department, EditDepartmentEmailResponse> {
    @Override
    public EditDepartmentEmailResponse convert(Department source) {
        return EditDepartmentEmailResponse.builder()
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
