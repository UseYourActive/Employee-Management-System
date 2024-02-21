package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.bygender.FindEmployeesByGenderOperation;
import com.ems.employee_service.api.operations.find.bygender.FindEmployeesByGenderRequest;
import com.ems.employee_service.api.operations.find.bygender.FindEmployeesByGenderResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeesByGenderOperationProcessor implements FindEmployeesByGenderOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeesByGenderResponse process(final FindEmployeesByGenderRequest request) {
        return null;
    }
}
