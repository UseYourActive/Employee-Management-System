package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.byzipcode.FindEmployeesByZipCodeOperation;
import com.ems.employee_service.api.operations.find.byzipcode.FindEmployeesByZipCodeRequest;
import com.ems.employee_service.api.operations.find.byzipcode.FindEmployeesByZipCodeResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeesByZipCodeOperationProcessor implements FindEmployeesByZipCodeOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeesByZipCodeResponse process(final FindEmployeesByZipCodeRequest request) {
        return null;
    }
}
