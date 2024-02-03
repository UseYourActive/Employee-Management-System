package com.ems.employee_service.api.operations.find.all;

import com.ems.employee_service.api.base.OperationOutput;
import com.ems.employee_service.api.operations.EmployeeResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Schema(
        description = "Employee Response DTO for finding all books."
)
@Getter
@Builder
@AllArgsConstructor
public class FindAllEmployeesResponse implements OperationOutput {
    private List<EmployeeResponseDTO> employeeResponseDTOS;
}
