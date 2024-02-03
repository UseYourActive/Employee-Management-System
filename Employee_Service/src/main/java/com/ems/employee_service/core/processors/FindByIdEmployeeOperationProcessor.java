package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.byid.FindByIdEmployeeOperation;
import com.ems.employee_service.api.operations.find.byid.FindByIdEmployeeRequest;
import com.ems.employee_service.api.operations.find.byid.FindByIdEmployeeResponse;
import com.ems.employee_service.core.exceptions.EmployeeNotFoundException;
import com.ems.employee_service.core.mappers.FindByIdEmployeeMapper;
import com.ems.employee_service.persistence.entities.Employee;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindByIdEmployeeOperationProcessor implements FindByIdEmployeeOperation {
    private final EmployeeRepository employeeRepository;
    private final FindByIdEmployeeMapper employeeMapper;

    @Override
    public FindByIdEmployeeResponse process(final FindByIdEmployeeRequest request) {
        log.info("Processing request to find employee by ID: {}", request.getId());

        Employee employee = employeeRepository.findById(UUID.fromString(request.getId()))
                .orElseThrow(() -> {
                    log.warn("Employee with ID {} not found. Unable to proceed.", request.getId());
                    return new EmployeeNotFoundException("Employee with given id has not been found");
                });

        log.info("Employee with ID {} found successfully", request.getId());

        FindByIdEmployeeResponse response = employeeMapper.mapToResponse(employee);
        log.info("Returning response for employee with ID {}: {}", request.getId(), response);

        return response;
    }
}
