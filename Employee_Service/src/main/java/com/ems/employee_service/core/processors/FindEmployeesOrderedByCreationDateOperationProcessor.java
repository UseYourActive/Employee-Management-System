package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.bycreationdate.FindEmployeesOrderedByCreationDateOperation;
import com.ems.employee_service.api.operations.find.bycreationdate.FindEmployeesOrderedByCreationDateRequest;
import com.ems.employee_service.api.operations.find.bycreationdate.FindEmployeesOrderedByCreationDateResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeesOrderedByCreationDateOperationProcessor implements FindEmployeesOrderedByCreationDateOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeesOrderedByCreationDateResponse process(final FindEmployeesOrderedByCreationDateRequest request) {
        return null;
    }
}
