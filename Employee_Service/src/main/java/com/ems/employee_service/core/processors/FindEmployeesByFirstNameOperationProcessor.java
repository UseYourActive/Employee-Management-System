package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.bynames.first.FindEmployeesByFirstNameOperation;
import com.ems.employee_service.api.operations.find.bynames.first.FindEmployeesByFirstNameRequest;
import com.ems.employee_service.api.operations.find.bynames.first.FindEmployeesByFirstNameResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeesByFirstNameOperationProcessor implements FindEmployeesByFirstNameOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeesByFirstNameResponse process(final FindEmployeesByFirstNameRequest request) {
        return null;
    }
}
