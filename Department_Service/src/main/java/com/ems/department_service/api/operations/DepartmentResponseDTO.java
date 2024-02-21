package com.ems.department_service.api.operations;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponseDTO {

    @Schema(description = "ID of the department", example = "12345678-1234-1234-1234-123456789abc")
    private String id;

    @Schema(description = "Name of the department", example = "Engineering")
    private String name;

    @Schema(description = "Description of the department", example = "Responsible for developing new technologies")
    private String description;

    @Schema(description = "Budget of the department", example = "100000")
    private String budget;

    @Schema(description = "Location of the department", example = "New York")
    private String location;

    @Schema(description = "Phone number of the department", example = "+1234567890")
    private String phoneNumber;

    @Schema(description = "Email of the department", example = "engineering@example.com")
    private String email;
}
