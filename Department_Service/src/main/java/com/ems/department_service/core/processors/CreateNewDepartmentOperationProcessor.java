package com.ems.department_service.core.processors;

import com.ems.department_service.api.operations.create.CreateNewDepartmentOperation;
import com.ems.department_service.api.operations.create.CreateNewDepartmentRequest;
import com.ems.department_service.api.operations.create.CreateNewDepartmentResponse;
import com.ems.department_service.core.mappers.CreateNewDepartmentMapper;
import com.ems.department_service.persistence.entities.Department;
import com.ems.department_service.persistence.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Slf4j
@Service
public class CreateNewDepartmentOperationProcessor implements CreateNewDepartmentOperation {
    private final DepartmentRepository departmentRepository;
    private final CreateNewDepartmentMapper mapper;

    @Override
    public CreateNewDepartmentResponse process(final CreateNewDepartmentRequest request) {
        String name = request.getName();
        String budget = request.getBudget();
        String description = request.getDescription();
        String email = request.getEmail();
        String location = request.getLocation();
        String phoneNumber = request.getPhoneNumber();

        Department department = Department.builder()
                .budget(new BigDecimal(budget))
                .email(email)
                .location(location)
                .phoneNumber(phoneNumber)
                .description(description)
                .name(name)
                .build();

        Department savedDepartment = departmentRepository.save(department);

        CreateNewDepartmentResponse response = mapper.convert(savedDepartment);

        return response;
    }
}
