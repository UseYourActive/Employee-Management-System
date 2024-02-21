package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.bynames.last.FindEmployeesByLastNameOperation;
import com.ems.employee_service.api.operations.find.bynames.last.FindEmployeesByLastNameRequest;
import com.ems.employee_service.api.operations.find.bynames.last.FindEmployeesByLastNameResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeesByLastNameOperationProcessor implements FindEmployeesByLastNameOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeesByLastNameResponse process(final FindEmployeesByLastNameRequest request) {
        return null;
    }
}
