package com.ems.leave_service.core.processors;

import com.ems.leave_service.api.operations.reject_leave.RejectLeaveOperation;
import com.ems.leave_service.api.operations.reject_leave.RejectLeaveRequest;
import com.ems.leave_service.api.operations.reject_leave.RejectLeaveResponse;
import com.ems.leave_service.core.exceptions.LeaveNotFoundException;
import com.ems.leave_service.persistence.entities.Leave;
import com.ems.leave_service.persistence.enums.LeaveStatus;
import com.ems.leave_service.persistence.repositories.LeaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class RejectLeaveOperationProcessor implements RejectLeaveOperation {
    private final LeaveRepository leaveRepository;
    @Override
    public RejectLeaveResponse process(final RejectLeaveRequest request) {
        String id = request.getId();

        Leave leave = leaveRepository.findById(UUID.fromString(id))
                .orElseThrow(LeaveNotFoundException::new);

        leave.setStatus(LeaveStatus.REJECTED);

        Leave persistedLeave = leaveRepository.save(leave);

        RejectLeaveResponse response = RejectLeaveResponse.builder()
                .isSuccessfullyRejected(Boolean.TRUE)
                .build();

        return response;
    }
}
