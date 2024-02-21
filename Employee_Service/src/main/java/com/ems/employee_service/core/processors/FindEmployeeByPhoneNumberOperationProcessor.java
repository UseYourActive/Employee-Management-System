package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.byphonenumber.FindEmployeeByPhoneNumberOperation;
import com.ems.employee_service.api.operations.find.byphonenumber.FindEmployeeByPhoneNumberRequest;
import com.ems.employee_service.api.operations.find.byphonenumber.FindEmployeeByPhoneNumberResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeeByPhoneNumberOperationProcessor implements FindEmployeeByPhoneNumberOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeeByPhoneNumberResponse process(final FindEmployeeByPhoneNumberRequest request) {
        return null;
    }
}
