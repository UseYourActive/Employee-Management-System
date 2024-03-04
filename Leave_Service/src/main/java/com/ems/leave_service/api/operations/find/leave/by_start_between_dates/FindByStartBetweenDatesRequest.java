package com.ems.leave_service.api.operations.find.leave.by_start_between_dates;

import com.ems.leave_service.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindByStartBetweenDatesRequest implements OperationInput {
    private String startDate;
    private String endDate;
}
