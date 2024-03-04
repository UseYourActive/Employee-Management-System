package com.ems.leave_service.core.processors;

import com.ems.leave_service.api.operations.edit.EditLeaveOperation;
import com.ems.leave_service.api.operations.edit.EditLeaveRequest;
import com.ems.leave_service.api.operations.edit.EditLeaveResponse;
import com.ems.leave_service.persistence.repositories.LeaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EditLeaveOperationProcessor implements EditLeaveOperation {
    private final LeaveRepository leaveRepository;

    @Override
    public EditLeaveResponse process(final EditLeaveRequest request) {
        return null;
    }
}
