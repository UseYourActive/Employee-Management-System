package com.ems.employee_service.core.mappers;

import com.ems.employee_service.api.operations.find.byid.FindByIdEmployeeResponse;
import com.ems.employee_service.persistence.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FindByIdEmployeeMapper {
    FindByIdEmployeeMapper INSTANCE = Mappers.getMapper(FindByIdEmployeeMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "middleName", target = "middleName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "uniqueCivilNumber", target = "uniqueCivilNumber")
    @Mapping(source = "designation", target = "designation")
    @Mapping(source = "department", target = "department")
    @Mapping(source = "contactInformation.email", target = "contactInformation.email")
    @Mapping(source = "contactInformation.phoneNumber", target = "contactInformation.phoneNumber")
    @Mapping(source = "salary.amount", target = "salary.amount")
    @Mapping(source = "salary.effectiveDate", target = "salary.effectiveDate")
    @Mapping(source = "creation.createdAt", target = "creation.createdAt")
    @Mapping(source = "creation.lastModifiedAt", target = "creation.lastModifiedAt")
    @Mapping(source = "employeeDetails.gender", target = "employeeDetails.gender")
    @Mapping(source = "employeeDetails.dateOfBirth", target = "employeeDetails.dateOfBirth")
    @Mapping(source = "employeeDetails.maritalStatus", target = "employeeDetails.maritalStatus")
    @Mapping(source = "employeeDetails.address.city", target = "employeeDetails.address.city")
    @Mapping(source = "employeeDetails.address.street", target = "employeeDetails.address.street")
    @Mapping(source = "employeeDetails.address.zipCode", target = "employeeDetails.address.zipCode")
    FindByIdEmployeeResponse mapToResponse(Employee employee);
}
