package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.bysalary.range.FindEmployeesBySalaryRangeOperation;
import com.ems.employee_service.api.operations.find.bysalary.range.FindEmployeesBySalaryRangeRequest;
import com.ems.employee_service.api.operations.find.bysalary.range.FindEmployeesBySalaryRangeResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeesBySalaryRangeOperationProcessor implements FindEmployeesBySalaryRangeOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeesBySalaryRangeResponse process(final FindEmployeesBySalaryRangeRequest request) {
        return null;
    }
}
