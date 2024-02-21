package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.bydesignation.FindEmployeesByDesignationOperation;
import com.ems.employee_service.api.operations.find.bydesignation.FindEmployeesByDesignationRequest;
import com.ems.employee_service.api.operations.find.bydesignation.FindEmployeesByDesignationResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeesByDesignationOperationProcessor implements FindEmployeesByDesignationOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeesByDesignationResponse process(final FindEmployeesByDesignationRequest request) {
        return null;
    }
}
