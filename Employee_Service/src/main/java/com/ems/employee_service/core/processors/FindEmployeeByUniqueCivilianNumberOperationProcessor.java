package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.byucn.FindEmployeeByUniqueCivilianNumberOperation;
import com.ems.employee_service.api.operations.find.byucn.FindEmployeeByUniqueCivilianNumberRequest;
import com.ems.employee_service.api.operations.find.byucn.FindEmployeeByUniqueCivilianNumberResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeeByUniqueCivilianNumberOperationProcessor implements FindEmployeeByUniqueCivilianNumberOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeeByUniqueCivilianNumberResponse process(final FindEmployeeByUniqueCivilianNumberRequest request) {
        return null;
    }
}
