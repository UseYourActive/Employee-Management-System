package com.ems.department_service.api.operations.find.all;

import com.ems.department_service.api.base.OperationInput;
import lombok.*;

@Builder
@Getter
public class FindAllDepartmentsRequest implements OperationInput {
    private Integer pageNumber;
    private Integer numberOfBooksPerPage;
}
