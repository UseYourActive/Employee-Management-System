package com.ems.department_service.core.converters;

import com.ems.department_service.api.operations.edit.name.EditDepartmentNameResponse;
import com.ems.department_service.persistence.entities.Department;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EditDepartmentNameConverter implements Converter<Department, EditDepartmentNameResponse> {
    @Override
    public EditDepartmentNameResponse convert(Department source) {
        return EditDepartmentNameResponse.builder()
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
