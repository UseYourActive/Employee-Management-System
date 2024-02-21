package com.ems.department_service.core.processors;

import com.ems.department_service.api.operations.edit.phone_number.EditDepartmentPhoneNumberOperation;
import com.ems.department_service.api.operations.edit.phone_number.EditDepartmentPhoneNumberRequest;
import com.ems.department_service.api.operations.edit.phone_number.EditDepartmentPhoneNumberResponse;
import com.ems.department_service.core.converters.EditDepartmentPhoneNumberConverter;
import com.ems.department_service.core.exceptions.DepartmentNotFoundException;
import com.ems.department_service.persistence.entities.Department;
import com.ems.department_service.persistence.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class EditDepartmentPhoneNumberOperationProcessor implements EditDepartmentPhoneNumberOperation {
    private final DepartmentRepository departmentRepository;
    private final EditDepartmentPhoneNumberConverter converter;

    @Override
    public EditDepartmentPhoneNumberResponse process(final EditDepartmentPhoneNumberRequest request) {
        String id = request.getId();
        String phoneNumber = request.getPhoneNumber();

        log.info("Processing request to edit phone number for department with ID: {}", id);

        Department department = departmentRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> {
                    log.warn("Department with ID {} not found. Unable to proceed.", id);
                    return new DepartmentNotFoundException("Department with given id has not been found");
                });

        log.debug("Department found with ID {}: {}", id, department);

        department.setPhoneNumber(phoneNumber);

        Department savedDepartment = departmentRepository.save(department);

        log.info("Phone number updated successfully for department with ID: {}", id);

        return converter.convert(savedDepartment);
    }
}
