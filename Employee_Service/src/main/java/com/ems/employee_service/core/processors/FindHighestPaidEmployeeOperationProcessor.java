package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.bysalary.highestpaid.FindHighestPaidEmployeeOperation;
import com.ems.employee_service.api.operations.find.bysalary.highestpaid.FindHighestPaidEmployeeRequest;
import com.ems.employee_service.api.operations.find.bysalary.highestpaid.FindHighestPaidEmployeeResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindHighestPaidEmployeeOperationProcessor implements FindHighestPaidEmployeeOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindHighestPaidEmployeeResponse process(final FindHighestPaidEmployeeRequest request) {
        return null;
    }
}
