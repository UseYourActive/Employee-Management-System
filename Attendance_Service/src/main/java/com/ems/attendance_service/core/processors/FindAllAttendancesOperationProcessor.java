package com.ems.attendance_service.core.processors;

import com.ems.attendance_service.api.operations.FindAllAttendancesOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindAllAttendancesOperationProcessor implements FindAllAttendancesOperation {
    @Override
    public FindAllAttendancesResponse process(final FindAllAttendancesRequest request) {
        return null;
    }
}
