package com.ems.department_service.api.operations.find.byid;

import com.ems.department_service.api.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FindByIdDepartmentRequest implements OperationInput {
    @NotBlank(message = "ID cannot be blank")
    @Schema(description = "Unique identifier of the department", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;
}
