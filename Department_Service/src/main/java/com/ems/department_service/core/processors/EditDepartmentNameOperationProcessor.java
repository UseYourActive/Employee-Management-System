package com.ems.department_service.core.processors;

import com.ems.department_service.api.operations.edit.name.EditDepartmentNameOperation;
import com.ems.department_service.api.operations.edit.name.EditDepartmentNameRequest;
import com.ems.department_service.api.operations.edit.name.EditDepartmentNameResponse;
import com.ems.department_service.core.converters.EditDepartmentNameConverter;
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
public class EditDepartmentNameOperationProcessor implements EditDepartmentNameOperation {
    private final DepartmentRepository departmentRepository;
    private final EditDepartmentNameConverter converter;

    @Override
    public EditDepartmentNameResponse process(final EditDepartmentNameRequest request) {
        String name = request.getName();
        String id = request.getId();

        log.info("Processing request to edit name for department with ID: {}", id);

        Department department = departmentRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> {
                    log.warn("Department with ID {} not found. Unable to proceed.", id);
                    return new DepartmentNotFoundException("Department with given id has not been found");
                });

        log.debug("Department found with ID {}: {}", id, department);

        department.setName(name);

        Department savedDepartment = departmentRepository.save(department);

        log.info("Name updated successfully for department with ID: {}", id);

        return converter.convert(savedDepartment);
    }
}
