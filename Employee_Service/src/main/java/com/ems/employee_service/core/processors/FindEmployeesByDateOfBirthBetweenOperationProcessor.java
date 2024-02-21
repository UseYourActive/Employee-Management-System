package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.bydateofbirth.FindEmployeesByDateOfBirthBetweenOperation;
import com.ems.employee_service.api.operations.find.bydateofbirth.FindEmployeesByDateOfBirthBetweenRequest;
import com.ems.employee_service.api.operations.find.bydateofbirth.FindEmployeesByDateOfBirthBetweenResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeesByDateOfBirthBetweenOperationProcessor implements FindEmployeesByDateOfBirthBetweenOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeesByDateOfBirthBetweenResponse process(final FindEmployeesByDateOfBirthBetweenRequest request) {
        return null;
    }
}
