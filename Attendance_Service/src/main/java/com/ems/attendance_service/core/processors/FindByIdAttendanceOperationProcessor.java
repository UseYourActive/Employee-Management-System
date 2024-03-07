package com.ems.attendance_service.core.processors;

import com.ems.attendance_service.api.operations.FindByIdAttendanceOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindByIdAttendanceOperationProcessor implements FindByIdAttendanceOperation {
    @Override
    public FindByIdAttendanceResponse process(final FindByIdAttendanceRequest request) {
        return null;
    }
}
