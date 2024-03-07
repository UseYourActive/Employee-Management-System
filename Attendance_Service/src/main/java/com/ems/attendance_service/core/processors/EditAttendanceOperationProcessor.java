package com.ems.attendance_service.core.processors;

import com.ems.attendance_service.api.operations.EditAttendanceOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EditAttendanceOperationProcessor implements EditAttendanceOperation {
    @Override
    public EditAttendanceResponse process(final EditAttendanceRequest request) {
        return null;
    }
}
