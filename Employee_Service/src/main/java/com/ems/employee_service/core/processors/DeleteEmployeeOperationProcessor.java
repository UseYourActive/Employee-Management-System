package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.delete.DeleteEmployeeOperation;
import com.ems.employee_service.api.operations.delete.DeleteEmployeeRequest;
import com.ems.employee_service.api.operations.delete.DeleteEmployeeResponse;
import com.ems.employee_service.core.exceptions.EmployeeNotFoundException;
import com.ems.employee_service.persistence.entities.Employee;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteEmployeeOperationProcessor implements DeleteEmployeeOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public DeleteEmployeeResponse process(final DeleteEmployeeRequest request) {
        String id = request.getId();

        log.info("Processing request to delete an employee with ID: {}", id);

        Employee employee = employeeRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> {
                    log.warn("Employee with ID {} not found. Unable to delete.", id);
                    return new EmployeeNotFoundException("Employee with given id has not been found");
                });

        employeeRepository.delete(employee);
        log.info("Employee with ID {} deleted successfully", id);

        DeleteEmployeeResponse response = DeleteEmployeeResponse.builder()
                .successfullyDeletedEmployee(Boolean.TRUE)
                .build();

        log.info("Returning response for deleted employee: {}", response);

        return response;
    }
}
