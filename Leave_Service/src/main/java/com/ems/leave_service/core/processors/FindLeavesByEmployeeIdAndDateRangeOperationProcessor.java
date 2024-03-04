package com.ems.leave_service.core.processors;

import com.ems.leave_service.api.operations.LeaveResponseDTO;
import com.ems.leave_service.api.operations.find.leave.leaves_by_employee_id_and_date_range.FindLeavesByEmployeeIdAndDateRangeOperation;
import com.ems.leave_service.api.operations.find.leave.leaves_by_employee_id_and_date_range.FindLeavesByEmployeeIdAndDateRangeRequest;
import com.ems.leave_service.api.operations.find.leave.leaves_by_employee_id_and_date_range.FindLeavesByEmployeeIdAndDateRangeResponse;
import com.ems.leave_service.core.converters.LeaveResponseDTOConverter;
import com.ems.leave_service.persistence.entities.Leave;
import com.ems.leave_service.persistence.repositories.LeaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindLeavesByEmployeeIdAndDateRangeOperationProcessor implements FindLeavesByEmployeeIdAndDateRangeOperation {
    private final LeaveRepository leaveRepository;
    private final LeaveResponseDTOConverter converter;

    @Override
    public FindLeavesByEmployeeIdAndDateRangeResponse process(final FindLeavesByEmployeeIdAndDateRangeRequest request) {
        String employeeId = request.getEmployeeId();
        String startDate = request.getStartDate();
        String endDate = request.getEndDate();

        List<Leave> findLeavesByEmployeeIdAndDateRange =
                leaveRepository.findLeavesByEmployeeIdAndDateRange(UUID.fromString(employeeId), LocalDate.parse(startDate), LocalDate.parse(endDate));

        List<LeaveResponseDTO> list = findLeavesByEmployeeIdAndDateRange.stream()
                .map(converter::convert)
                .toList();

        return FindLeavesByEmployeeIdAndDateRangeResponse.builder()
                .leaveResponseDTOS(list)
                .build();
    }
}
