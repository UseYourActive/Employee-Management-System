package com.ems.department_service.api.operations.edit.location;

import com.ems.department_service.api.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditDepartmentLocationRequest implements OperationInput {

    @NotBlank(message = "ID must not be blank")
    @Schema(description = "ID of the department", example = "12345678-1234-1234-1234-123456789abc")
    private String id;

    @NotBlank(message = "Location must not be blank")
    @Schema(description = "New location of the department", example = "Building B, Floor 2")
    private String location;
}
