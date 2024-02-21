package com.ems.department_service.api.operations.edit.phone_number;

import com.ems.department_service.api.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditDepartmentPhoneNumberRequest implements OperationInput {

    @NotBlank(message = "ID must not be blank")
    @Schema(description = "ID of the department", example = "12345678-1234-1234-1234-123456789abc")
    private String id;

    @Schema(description = "New phone number of the department", example = "+1234567890")
    private String phoneNumber;
}
