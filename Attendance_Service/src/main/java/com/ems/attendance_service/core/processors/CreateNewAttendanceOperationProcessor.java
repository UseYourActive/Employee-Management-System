package com.ems.attendance_service.core.processors;

import com.ems.attendance_service.api.operations.CreateNewAttendanceOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateNewAttendanceOperationProcessor implements CreateNewAttendanceOperation {
    @Override
    public CreateNewAttendanceResponse process(final CreateNewAttendanceRequest request) {
        return null;
    }
}
