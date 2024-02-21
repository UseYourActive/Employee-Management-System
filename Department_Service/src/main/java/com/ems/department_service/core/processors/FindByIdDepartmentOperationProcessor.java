package com.ems.department_service.core.processors;

import com.ems.department_service.api.operations.find.byid.FindByIdDepartmentOperation;
import com.ems.department_service.api.operations.find.byid.FindByIdDepartmentRequest;
import com.ems.department_service.api.operations.find.byid.FindByIdDepartmentResponse;
import com.ems.department_service.core.exceptions.DepartmentNotFoundException;
import com.ems.department_service.core.converters.FindByIdDepartmentMapper;
import com.ems.department_service.persistence.entities.Department;
import com.ems.department_service.persistence.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindByIdDepartmentOperationProcessor implements FindByIdDepartmentOperation {
    private final DepartmentRepository departmentRepository;
    private final FindByIdDepartmentMapper converter;

    @Override
    public FindByIdDepartmentResponse process(final FindByIdDepartmentRequest request) {
        log.info("Processing request to find department by ID: {}", request.getId());

        String id = request.getId();

        Department department = departmentRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> {
                    log.warn("Department with ID {} not found. Unable to proceed.", id);
                    return new DepartmentNotFoundException("Department with given id has not been found");
                });

        log.info("Department with ID {} found successfully", id);

        FindByIdDepartmentResponse response = converter.convert(department);
        log.info("Returning response for department with ID {}: {}", id, response);

        return response;
    }
}
