package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.bysalary.greaterthan.FindEmployeesWithSalaryGreaterThanOperation;
import com.ems.employee_service.api.operations.find.bysalary.greaterthan.FindEmployeesWithSalaryGreaterThanRequest;
import com.ems.employee_service.api.operations.find.bysalary.greaterthan.FindEmployeesWithSalaryGreaterThanResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeesWithSalaryGreaterThanOperationProcessor implements FindEmployeesWithSalaryGreaterThanOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeesWithSalaryGreaterThanResponse process(final FindEmployeesWithSalaryGreaterThanRequest request) {
        return null;
    }
}
