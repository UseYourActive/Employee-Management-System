package com.ems.department_service.api.operations.find.all;

import com.ems.department_service.api.base.OperationInput;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FindAllDepartmentsRequest implements OperationInput {

    @Min(value = 1, message = "Page number must be greater than or equal to 1")
    @Schema(description = "Page number for pagination", minimum = "1", example = "1")
    private Integer pageNumber;

    @Min(value = 1, message = "Number of books per page must be greater than or equal to 1")
    @Schema(description = "Number of departments per page", minimum = "1", example = "10")
    private Integer numberOfBooksPerPage;
}
