package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.bymaritalstatus.FindEmployeesByEmployeeDetailsMaritalStatusOperation;
import com.ems.employee_service.api.operations.find.bymaritalstatus.FindEmployeesByEmployeeDetailsMaritalStatusRequest;
import com.ems.employee_service.api.operations.find.bymaritalstatus.FindEmployeesByEmployeeDetailsMaritalStatusResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeesByEmployeeDetailsMaritalStatusOperationProcessor implements FindEmployeesByEmployeeDetailsMaritalStatusOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeesByEmployeeDetailsMaritalStatusResponse process(final FindEmployeesByEmployeeDetailsMaritalStatusRequest request) {
        return null;
    }
}
