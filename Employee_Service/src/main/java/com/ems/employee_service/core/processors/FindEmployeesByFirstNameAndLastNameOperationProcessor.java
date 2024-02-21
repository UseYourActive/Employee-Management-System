package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.find.bynames.middleandlast.FindEmployeesByFirstNameAndLastNameOperation;
import com.ems.employee_service.api.operations.find.bynames.middleandlast.FindEmployeesByFirstNameAndLastNameRequest;
import com.ems.employee_service.api.operations.find.bynames.middleandlast.FindEmployeesByFirstNameAndLastNameResponse;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindEmployeesByFirstNameAndLastNameOperationProcessor implements FindEmployeesByFirstNameAndLastNameOperation {
    private final EmployeeRepository employeeRepository;

    @Override
    public FindEmployeesByFirstNameAndLastNameResponse process(final FindEmployeesByFirstNameAndLastNameRequest request) {
        return null;
    }
}
