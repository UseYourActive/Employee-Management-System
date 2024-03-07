package com.ems.leave_service.rest.controllers;

import com.ems.leave_service.api.operations.find.leave.all.FindAllLeavesOperation;
import com.ems.leave_service.api.operations.find.leave.by_employee_id.FindByEmployeeIdOperation;
import com.ems.leave_service.api.operations.find.leave.by_employee_id_and_status.FindByEmployeeIdAndStatusOperation;
import com.ems.leave_service.api.operations.find.leave.by_start_between_dates.FindByStartBetweenDatesOperation;
import com.ems.leave_service.api.operations.find.leave.by_status.FindByStatusOperation;
import com.ems.leave_service.api.operations.find.leave.leaves_by_employee_id_and_date_range.FindLeavesByEmployeeIdAndDateRangeOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "CRUD REST APIs for Leave Management",
        description = "CRUD REST API"
)
@RequiredArgsConstructor
@RestController
@Validated
@RefreshScope
@Slf4j
@CrossOrigin
@RequestMapping(path = "/leave")
public class LeaveController {
    private final FindAllLeavesOperation findAllLeavesOperation;
    private final FindByEmployeeIdOperation findByEmployeeIdOperation;
    private final FindByEmployeeIdAndStatusOperation findByEmployeeIdAndStatusOperation;
    private final FindByStartBetweenDatesOperation findByStartBetweenDatesOperation;
    private final FindByStatusOperation findByStatusOperation;
    private final FindLeavesByEmployeeIdAndDateRangeOperation findLeavesByEmployeeIdAndDateRangeOperation;

    //region GET
    //endregion

    //region POST
    //endregion

    //region PUT
    //endregion

    //region DELETE
    //endregion
}
