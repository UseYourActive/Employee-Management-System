package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.bysalary.anddesignation.FindEmployeesByDesignationOrderBySalaryOperation;
import com.ems.employee_service.api.operations.find.bysalary.anddesignation.FindEmployeesByDesignationOrderBySalaryRequest;
import com.ems.employee_service.api.operations.find.bysalary.anddesignation.FindEmployeesByDesignationOrderBySalaryResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeesByDesignationOrderBySalaryOperationProcessor implements FindEmployeesByDesignationOrderBySalaryOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeesByDesignationOrderBySalaryResponse process(final FindEmployeesByDesignationOrderBySalaryRequest request) {
        return null;
    }
}
