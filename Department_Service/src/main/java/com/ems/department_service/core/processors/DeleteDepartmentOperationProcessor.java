package com.ems.department_service.core.processors;

import com.ems.department_service.api.operations.delete.DeleteDepartmentOperation;
import com.ems.department_service.api.operations.delete.DeleteDepartmentRequest;
import com.ems.department_service.api.operations.delete.DeleteDepartmentResponse;
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
public class DeleteDepartmentOperationProcessor implements DeleteDepartmentOperation {
    private final DepartmentRepository departmentRepository;

    @Override
    public DeleteDepartmentResponse process(final DeleteDepartmentRequest request) {
        String id = request.getId();

        log.info("Processing request to delete a department with ID: {}", id);

        Department department = departmentRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> {
                    log.warn("Department with ID {} not found. Unable to delete.", id);
                    return new DepartmentNotFoundException("Department with given id has not been found");
                });

        departmentRepository.delete(department);
        log.info("Department with ID {} deleted successfully", id);

        DeleteDepartmentResponse response = DeleteDepartmentResponse.builder()
                .successfullyDeletedDepartment(Boolean.TRUE)
                .build();

        log.info("Returning response for deleted department: {}", response);

        return response;
    }
}
