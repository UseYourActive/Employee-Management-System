package com.ems.department_service.core.processors;

import com.ems.department_service.api.operations.edit.budget.EditDepartmentBudgetOperation;
import com.ems.department_service.api.operations.edit.budget.EditDepartmentBudgetRequest;
import com.ems.department_service.api.operations.edit.budget.EditDepartmentBudgetResponse;
import com.ems.department_service.core.converters.EditDepartmentBudgetConverter;
import com.ems.department_service.core.exceptions.DepartmentNotFoundException;
import com.ems.department_service.persistence.entities.Department;
import com.ems.department_service.persistence.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class EditDepartmentBudgetOperationProcessor implements EditDepartmentBudgetOperation {
    private final DepartmentRepository departmentRepository;
    private final EditDepartmentBudgetConverter converter;

    @Override
    public EditDepartmentBudgetResponse process(final EditDepartmentBudgetRequest request) {
        String id = request.getId();
        String budget = request.getBudget();

        log.info("Processing request to edit budget for department with ID: {}", id);

        Department department = departmentRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> {
                    log.warn("Department with ID {} not found. Unable to proceed.", id);
                    return new DepartmentNotFoundException("Department with given id has not been found");
                });

        log.debug("Department found with ID {}: {}", id, department);

        department.setBudget(new BigDecimal(budget));

        Department savedDepartment = departmentRepository.save(department);

        log.info("Budget updated successfully for department with ID: {}", id);

        return converter.convert(savedDepartment);
    }
}
