package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.bysalary.topthree.FindTopThreeByOrderBySalaryAmountDescOperation;
import com.ems.employee_service.api.operations.find.bysalary.topthree.FindTopThreeByOrderBySalaryAmountDescRequest;
import com.ems.employee_service.api.operations.find.bysalary.topthree.FindTopThreeByOrderBySalaryAmountDescResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindTopThreeByOrderBySalaryAmountDescOperationProcessor implements FindTopThreeByOrderBySalaryAmountDescOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindTopThreeByOrderBySalaryAmountDescResponse process(final FindTopThreeByOrderBySalaryAmountDescRequest request) {
        return null;
    }
}
