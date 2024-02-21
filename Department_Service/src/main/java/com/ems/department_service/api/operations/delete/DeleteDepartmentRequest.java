package com.ems.department_service.api.operations.delete;

import com.ems.department_service.api.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteDepartmentRequest implements OperationInput {

    @NotBlank(message = "ID must not be blank")
    @Schema(description = "ID of the department to delete", example = "12345678-abcd-90ab-cdef-1234567890ab")
    private String id;
}
