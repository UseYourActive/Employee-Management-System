package com.ems.leave_service.core.processors;

import com.ems.leave_service.api.operations.LeaveResponseDTO;
import com.ems.leave_service.api.operations.find.leave.by_employee_id.FindByEmployeeIdOperation;
import com.ems.leave_service.api.operations.find.leave.by_employee_id.FindByEmployeeIdRequest;
import com.ems.leave_service.api.operations.find.leave.by_employee_id.FindByEmployeeIdResponse;
import com.ems.leave_service.core.converters.LeaveResponseDTOConverter;
import com.ems.leave_service.persistence.entities.Leave;
import com.ems.leave_service.persistence.repositories.LeaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindLeaveByEmployeeIdOperationProcessor implements FindByEmployeeIdOperation {
    private final LeaveRepository leaveRepository;
    private final LeaveResponseDTOConverter converter;

    @Override
    public FindByEmployeeIdResponse process(final FindByEmployeeIdRequest request) {
        String employeeId = request.getEmployeeId();

        List<Leave> findByEmployeeId = leaveRepository.findByEmployeeId(UUID.fromString(employeeId));

        List<LeaveResponseDTO> list = findByEmployeeId.stream()
                .map(converter::convert)
                .toList();

        return FindByEmployeeIdResponse.builder()
                .leaveResponseDTOS(list)
                .build();
    }
}
