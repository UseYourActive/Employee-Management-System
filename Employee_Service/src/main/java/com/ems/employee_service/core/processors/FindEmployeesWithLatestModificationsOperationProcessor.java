package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.latestmodifications.FindEmployeesWithLatestModificationsOperation;
import com.ems.employee_service.api.operations.find.latestmodifications.FindEmployeesWithLatestModificationsRequest;
import com.ems.employee_service.api.operations.find.latestmodifications.FindEmployeesWithLatestModificationsResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeesWithLatestModificationsOperationProcessor implements FindEmployeesWithLatestModificationsOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeesWithLatestModificationsResponse process(final FindEmployeesWithLatestModificationsRequest request) {
        return null;
    }
}
