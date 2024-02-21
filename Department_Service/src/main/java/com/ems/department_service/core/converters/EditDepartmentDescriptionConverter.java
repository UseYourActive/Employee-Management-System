package com.ems.department_service.core.converters;

import com.ems.department_service.api.operations.edit.description.EditDepartmentDescriptionResponse;
import com.ems.department_service.persistence.entities.Department;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EditDepartmentDescriptionConverter implements Converter<Department, EditDepartmentDescriptionResponse> {
    @Override
    public EditDepartmentDescriptionResponse convert(Department source) {
        return EditDepartmentDescriptionResponse.builder()
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
