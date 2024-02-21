package com.ems.department_service.core.processors;

import com.ems.department_service.api.operations.edit.description.EditDepartmentDescriptionOperation;
import com.ems.department_service.api.operations.edit.description.EditDepartmentDescriptionRequest;
import com.ems.department_service.api.operations.edit.description.EditDepartmentDescriptionResponse;
import com.ems.department_service.core.converters.EditDepartmentDescriptionConverter;
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
public class EditDepartmentDescriptionOperationProcessor implements EditDepartmentDescriptionOperation {
    private final DepartmentRepository departmentRepository;
    private final EditDepartmentDescriptionConverter converter;

    @Override
    public EditDepartmentDescriptionResponse process(final EditDepartmentDescriptionRequest request) {
        String id = request.getId();
        String description = request.getDescription();

        log.info("Processing request to edit description for department with ID: {}", id);

        Department department = departmentRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> {
                    log.warn("Department with ID {} not found. Unable to proceed.", id);
                    return new DepartmentNotFoundException("Department with given id has not been found");
                });

        log.debug("Department found with ID {}: {}", id, department);

        department.setDescription(description);

        Department savedDepartment = departmentRepository.save(department);

        log.info("Description updated successfully for department with ID: {}", id);

        return converter.convert(savedDepartment);
    }
}
