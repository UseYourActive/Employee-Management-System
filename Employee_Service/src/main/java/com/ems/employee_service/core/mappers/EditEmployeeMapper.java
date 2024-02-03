package com.ems.employee_service.core.mappers;

import com.ems.employee_service.api.operations.edit.EditEmployeeResponse;
import com.ems.employee_service.persistence.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EditEmployeeMapper {
    EditEmployeeMapper INSTANCE = Mappers.getMapper(EditEmployeeMapper.class);

    EditEmployeeResponse mapToResponse(Employee employee);
}
