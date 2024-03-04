package com.ems.leave_service.api.operations.find.leave.all;

import com.ems.leave_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
public class FindAllLeavesRequest implements OperationInput {
    private Integer pageNumber;
    private Integer numberOfBooksPerPage;
}
