package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.create.CreateNewEmployeeOperation;
import com.ems.employee_service.api.operations.create.CreateNewEmployeeRequest;
import com.ems.employee_service.api.operations.create.CreateNewEmployeeResponse;
import com.ems.employee_service.core.mappers.CreateNewEmployeeMapper;
import com.ems.employee_service.persistence.entities.*;
import com.ems.employee_service.persistence.enums.Department;
import com.ems.employee_service.persistence.enums.Designation;
import com.ems.employee_service.persistence.enums.Gender;
import com.ems.employee_service.persistence.enums.MaritalStatus;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateNewEmployeeOperationProcessor implements CreateNewEmployeeOperation {
    private final EmployeeRepository employeeRepository;
    private final CreateNewEmployeeMapper employeeMapper;

    @Override
    public CreateNewEmployeeResponse process(final CreateNewEmployeeRequest request) {
        log.info("Processing request to create a new employee");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Employee employee = Employee.builder()
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .uniqueCivilNumber(request.getUniqueCivilNumber())
                .designation(Designation.valueOf(request.getDesignation()))
                .department(Department.valueOf(request.getDepartment()))
                .contactInformation(ContactInformation.builder()
                        .email(request.getContactInformation().getEmail())
                        .phoneNumber(request.getContactInformation().getPhoneNumber())
                        .build())
                .salary(Salary.builder()
                        .amount(new BigDecimal(request.getSalary().getAmount()))
                        .effectiveDate(Date.from(LocalDate.parse(request.getSalary().getEffectiveDate(), dateFormatter).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .build())
                .creation(Creation.builder()
                        .createdAt(Date.from(Instant.now()))
                        .lastModifiedAt(Date.from(Instant.now()))
                        .build())
                .employeeDetails(EmployeeDetails.builder()
                        .address(Address.builder()
                                .city(request.getEmployeeDetails().getAddress().getCity())
                                .street(request.getEmployeeDetails().getAddress().getStreet())
                                .zipCode(request.getEmployeeDetails().getAddress().getZipCode())
                                .build())
                        .gender(Gender.valueOf(request.getEmployeeDetails().getGender()))
                        .maritalStatus(MaritalStatus.valueOf(request.getEmployeeDetails().getMaritalStatus()))
                        .dateOfBirth(Date.from(LocalDate.parse(request.getEmployeeDetails().getDateOfBirth(), dateFormatter).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                        .build())
                .build();
        log.info(employee.toString());
        Employee savedEmployee = employeeRepository.save(employee);
        log.info("Employee with ID {} created successfully", savedEmployee.getId());

        CreateNewEmployeeResponse response = employeeMapper.mapToResponse(savedEmployee);
        log.info("Returning response for created employee: {}", response);

        return response;
    }
}
