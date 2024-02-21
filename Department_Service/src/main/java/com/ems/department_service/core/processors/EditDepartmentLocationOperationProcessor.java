package com.ems.department_service.core.processors;

import com.ems.department_service.api.operations.edit.location.EditDepartmentLocationOperation;
import com.ems.department_service.api.operations.edit.location.EditDepartmentLocationRequest;
import com.ems.department_service.api.operations.edit.location.EditDepartmentLocationResponse;
import com.ems.department_service.core.converters.EditDepartmentLocationConverter;
import com.ems.department_service.core.exceptions.DepartmentNotFoundException;
import com.ems.department_service.persistence.entities.Department;
import com.ems.department_service.persistence.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class EditDepartmentLocationOperationProcessor implements EditDepartmentLocationOperation {
    private final DepartmentRepository departmentRepository;
    private final EditDepartmentLocationConverter converter;

    @Override
    public EditDepartmentLocationResponse process(final EditDepartmentLocationRequest request) {
        String id = request.getId();
        String location = request.getLocation();

        log.info("Processing request to edit location for department with ID: {}", id);

        Department department = departmentRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> {
                    log.warn("Department with ID {} not found. Unable to proceed.", id);
                    return new DepartmentNotFoundException("Department with given id has not been found");
                });

        log.debug("Department found with ID {}: {}", id, department);

        department.setLocation(location);

        Department savedDepartment = departmentRepository.save(department);

        log.info("Location updated successfully for department with ID: {}", id);

        return converter.convert(savedDepartment);
    }
}
