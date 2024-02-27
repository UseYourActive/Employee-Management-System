package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.byemail.FindEmployeeByEmailOperation;
import com.ems.employee_service.api.operations.find.byemail.FindEmployeeByEmailRequest;
import com.ems.employee_service.api.operations.find.byemail.FindEmployeeByEmailResponse;
import com.ems.employee_service.core.exceptions.EmployeeNotFoundException;
import com.ems.employee_service.persistence.entities.Employee;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeeByEmailOperationProcessor implements FindEmployeeByEmailOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeeByEmailResponse process(final FindEmployeeByEmailRequest request) {
        String email = request.getEmail();

        Employee employee = employeeRepository.findEmployeeByEmail(email)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with such email doesn't exist"));

//        return FindEmployeeByEmailResponse.builder()
//
//                .build();

        return null;
    }
}
