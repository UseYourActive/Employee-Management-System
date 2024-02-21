package com.ems.department_service.api.operations.find.all;

import com.ems.department_service.api.base.OperationOutput;
import com.ems.department_service.api.operations.DepartmentResponseDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindAllDepartmentsResponse implements OperationOutput {
    private List<DepartmentResponseDTO> departmentResponseDTOList;
}
