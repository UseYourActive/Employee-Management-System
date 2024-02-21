package com.ems.department_service.core.processors;

import com.ems.department_service.api.operations.DepartmentResponseDTO;
import com.ems.department_service.api.operations.find.all.FindAllDepartmentsOperation;
import com.ems.department_service.api.operations.find.all.FindAllDepartmentsRequest;
import com.ems.department_service.api.operations.find.all.FindAllDepartmentsResponse;
import com.ems.department_service.core.mappers.FindAllDepartmentsMapper;
import com.ems.department_service.persistence.entities.Department;
import com.ems.department_service.persistence.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindAllDepartmentsOperationProcessor implements FindAllDepartmentsOperation {
    private final DepartmentRepository departmentRepository;
    private final FindAllDepartmentsMapper mapper;

    @Override
    public FindAllDepartmentsResponse process(final FindAllDepartmentsRequest request) {
        log.info("Processing request to find all departments");

        PageRequest pageRequest = PageRequest.of(
                request.getPageNumber(),
                request.getNumberOfBooksPerPage());

        Page<Department> allDepartmentsList = departmentRepository.findAll(pageRequest);
        log.info("Found {} departments", allDepartmentsList.getTotalElements());

        List<DepartmentResponseDTO> departmentResponseDTOList = allDepartmentsList.stream()
                .map(mapper::convert)
                .toList();
        log.info("Mapped responses for all departments: {}", departmentResponseDTOList);

        FindAllDepartmentsResponse response = FindAllDepartmentsResponse.builder()
                .departmentResponseDTOList(departmentResponseDTOList)
                .build();
        log.info("Returning response for all departments: {}", response);

        return response;
    }
}
