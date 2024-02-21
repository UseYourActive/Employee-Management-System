package com.ems.employee_service.api.operations.find.byids;

import com.ems.employee_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindEmployeesByIdsRequest implements OperationInput {
    private String ids;
}
