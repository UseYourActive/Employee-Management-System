package com.ems.employee_service.api.operations;

import com.ems.employee_service.api.annotations.validators.ValidDate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Schema(description = "Creation DTO.")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreationDTO {
    @Schema(description = "Date when the record was created.")
    @NotNull(message = "Created at date cannot be null")
    @ValidDate
    private String createdAt;

    @Schema(description = "Date when the record was last modified.")
    @NotNull(message = "Last modified date cannot be null")
    @ValidDate
    private String lastModifiedAt;
}
