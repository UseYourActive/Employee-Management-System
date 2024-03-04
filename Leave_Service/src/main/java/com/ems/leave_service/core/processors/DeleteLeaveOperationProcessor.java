package com.ems.leave_service.core.processors;

import com.ems.leave_service.api.operations.delete.DeleteLeaveOperation;
import com.ems.leave_service.api.operations.delete.DeleteLeaveRequest;
import com.ems.leave_service.api.operations.delete.DeleteLeaveResponse;
import com.ems.leave_service.core.exceptions.LeaveNotFoundException;
import com.ems.leave_service.persistence.entities.Leave;
import com.ems.leave_service.persistence.repositories.LeaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteLeaveOperationProcessor implements DeleteLeaveOperation {
    private final LeaveRepository leaveRepository;

    @Override
    public DeleteLeaveResponse process(final DeleteLeaveRequest request) {
        String id = request.getId();

        leaveRepository.deleteById(UUID.fromString(id));

        DeleteLeaveResponse response = DeleteLeaveResponse.builder()
                .isSuccessful(Boolean.TRUE)
                .build();

        return response;
    }
}
