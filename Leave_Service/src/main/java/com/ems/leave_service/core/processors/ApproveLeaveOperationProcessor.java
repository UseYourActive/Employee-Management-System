package com.ems.leave_service.core.processors;

import com.ems.leave_service.api.operations.approve_leave.ApproveLeaveOperation;
import com.ems.leave_service.api.operations.approve_leave.ApproveLeaveRequest;
import com.ems.leave_service.api.operations.approve_leave.ApproveLeaveResponse;
import com.ems.leave_service.core.exceptions.LeaveNotFoundException;
import com.ems.leave_service.persistence.entities.Leave;
import com.ems.leave_service.persistence.enums.LeaveStatus;
import com.ems.leave_service.persistence.repositories.LeaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApproveLeaveOperationProcessor implements ApproveLeaveOperation {
    private final LeaveRepository leaveRepository;

    @Override
    public ApproveLeaveResponse process(final ApproveLeaveRequest request) {
        String id = request.getId();

        Leave leave = leaveRepository.findById(UUID.fromString(id))
                .orElseThrow(LeaveNotFoundException::new);

        leave.setStatus(LeaveStatus.APPROVED);

        Leave persistedLeave = leaveRepository.save(leave);

        ApproveLeaveResponse response = ApproveLeaveResponse.builder()
                .successfullyApprovedLeave(Boolean.TRUE)
                .build();

        return response;
    }
}
