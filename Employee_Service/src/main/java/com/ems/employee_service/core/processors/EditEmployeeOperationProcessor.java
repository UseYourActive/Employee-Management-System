package com.ems.employee_service.core.processors;

import com.ems.employee_service.api.operations.edit.EditEmployeeOperation;
import com.ems.employee_service.api.operations.edit.EditEmployeeRequest;
import com.ems.employee_service.api.operations.edit.EditEmployeeResponse;
import com.ems.employee_service.core.mappers.EditEmployeeMapper;
import com.ems.employee_service.persistence.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EditEmployeeOperationProcessor implements EditEmployeeOperation {
    private final EmployeeRepository employeeRepository;
    private final EditEmployeeMapper employeeMapper;
    @Override
    public EditEmployeeResponse process(EditEmployeeRequest editEmployeeRequest) {
        return null;
    }
}
