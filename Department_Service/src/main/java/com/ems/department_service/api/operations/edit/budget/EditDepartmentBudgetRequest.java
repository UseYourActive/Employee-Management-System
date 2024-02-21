package com.ems.department_service.api.operations.edit.budget;

import com.ems.department_service.api.annotations.validators.ValidBigDecimal;
import com.ems.department_service.api.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditDepartmentBudgetRequest implements OperationInput {

    @NotBlank(message = "ID must not be blank")
    @Schema(description = "ID of the department", example = "12345678-1234-1234-1234-123456789abc")
    private String id;

    @ValidBigDecimal
    @Schema(description = "New budget of the department", example = "10000.00")
    private String budget;
}
