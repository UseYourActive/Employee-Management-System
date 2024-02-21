package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.byids.FindEmployeesByIdsOperation;
import com.ems.employee_service.api.operations.find.byids.FindEmployeesByIdsRequest;
import com.ems.employee_service.api.operations.find.byids.FindEmployeesByIdsResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeesByIdsOperationProcessor implements FindEmployeesByIdsOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeesByIdsResponse process(final FindEmployeesByIdsRequest request) {
        return null;
    }
}
