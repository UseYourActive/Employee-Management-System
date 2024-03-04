package com.ems.leave_service.core.processors;

import com.ems.leave_service.api.operations.LeaveResponseDTO;
import com.ems.leave_service.api.operations.find.leave.by_employee_id_and_status.FindByEmployeeIdAndStatusOperation;
import com.ems.leave_service.api.operations.find.leave.by_employee_id_and_status.FindByEmployeeIdAndStatusRequest;
import com.ems.leave_service.api.operations.find.leave.by_employee_id_and_status.FindByEmployeeIdAndStatusResponse;
import com.ems.leave_service.core.converters.LeaveResponseDTOConverter;
import com.ems.leave_service.persistence.entities.Leave;
import com.ems.leave_service.persistence.enums.LeaveStatus;
import com.ems.leave_service.persistence.repositories.LeaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindLeaveByEmployeeIdAndStatus implements FindByEmployeeIdAndStatusOperation {
    private final LeaveRepository leaveRepository;
    private final LeaveResponseDTOConverter converter;

    @Override
    public FindByEmployeeIdAndStatusResponse process(final FindByEmployeeIdAndStatusRequest request) {
        String employeeId = request.getEmployeeId();
        String status = request.getStatus();

        List<Leave> findByEmployeeIdAndStatus = leaveRepository.findByEmployeeIdAndStatus(UUID.fromString(employeeId), LeaveStatus.valueOf(status));

        List<LeaveResponseDTO> list = findByEmployeeIdAndStatus.stream()
                .map(converter::convert)
                .toList();

        return FindByEmployeeIdAndStatusResponse.builder()
                .leaveResponseDTOS(list)
                .build();
    }
}
