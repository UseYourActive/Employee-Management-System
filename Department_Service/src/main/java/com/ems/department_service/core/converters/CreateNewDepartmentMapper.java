package com.ems.department_service.core.converters;

import com.ems.department_service.api.operations.create.CreateNewDepartmentResponse;
import com.ems.department_service.persistence.entities.Department;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateNewDepartmentMapper implements Converter<Department, CreateNewDepartmentResponse> {
    @Override
    public CreateNewDepartmentResponse convert(Department source) {
        return CreateNewDepartmentResponse.builder()
                .id(String.valueOf(source.getId()))
                .budget(String.valueOf(source.getBudget()))
                .email(source.getEmail())
                .location(source.getLocation())
                .phoneNumber(source.getPhoneNumber())
                .description(source.getDescription())
                .name(source.getName())
                .build();
    }
}
