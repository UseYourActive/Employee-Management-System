package com.ems.department_service.core.mappers;

import com.ems.department_service.api.operations.DepartmentResponseDTO;
import com.ems.department_service.persistence.entities.Department;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FindAllDepartmentsMapper implements Converter<Department, DepartmentResponseDTO> {
    @Override
    public DepartmentResponseDTO convert(Department source) {
        return DepartmentResponseDTO.builder()
                .id(String.valueOf(source.getId()))
                .email(source.getEmail())
                .name(source.getName())
                .budget(String.valueOf(source.getBudget()))
                .description(source.getDescription())
                .location(source.getLocation())
                .phoneNumber(source.getPhoneNumber())
                .build();
    }
}
