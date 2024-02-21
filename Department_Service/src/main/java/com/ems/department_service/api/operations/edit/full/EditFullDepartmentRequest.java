package com.ems.department_service.api.operations.edit.full;

import com.ems.department_service.api.base.OperationInput;
import com.ems.department_service.api.annotations.validators.ValidBigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditFullDepartmentRequest implements OperationInput {

    @NotBlank(message = "ID must not be blank")
    @Schema(description = "ID of the department", example = "12345678-1234-1234-1234-123456789abc")
    private String id;

    @NotBlank(message = "Name must not be blank")
    @Schema(description = "Name of the department", example = "Engineering")
    private String name;

    @NotBlank(message = "Description must not be blank")
    @Schema(description = "Description of the department", example = "Responsible for engineering tasks")
    private String description;

    @ValidBigDecimal
    @Schema(description = "Budget of the department", example = "100000.00")
    private String budget;

    @NotBlank(message = "Location must not be blank")
    @Schema(description = "Location of the department", example = "Building A, Floor 3")
    private String location;

    @NotBlank(message = "Phone number must not be blank")
    @Schema(description = "Phone number of the department", example = "+1234567890")
    private String phoneNumber;

    @Email(message = "Invalid email format")
    @Schema(description = "Email address of the department", example = "engineering@example.com")
    private String email;
}
