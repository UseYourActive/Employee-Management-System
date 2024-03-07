package com.ems.attendance_service.core.processors;

import com.ems.attendance_service.api.operations.DeleteAttendanceOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteAttendanceOperationProcessor implements DeleteAttendanceOperation {
    @Override
    public DeleteAttendanceResponse process(final DeleteAttendanceRequest request) {
        return null;
    }
}
