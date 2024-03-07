package com.ems.leave_service.core.processors;

import com.ems.leave_service.api.operations.find.leave.by_status.FindByStatusOperation;
import com.ems.leave_service.api.operations.find.leave.by_status.FindByStatusRequest;
import com.ems.leave_service.api.operations.find.leave.by_status.FindByStatusResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindByStatusOperationProcessor implements FindByStatusOperation {
    @Override
    public FindByStatusResponse process(final FindByStatusRequest request) {
        return null;
    }
}
