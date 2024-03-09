package com.ems.attendance_service.core.processors;

import com.ems.attendance_service.api.operations.FindByIdAttendanceOperation;
import com.ems.attendance_service.core.exceptions.AttendanceNotFoundException;
import com.ems.attendance_service.persistence.entities.Attendance;
import com.ems.attendance_service.persistence.repositories.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindByIdAttendanceOperationProcessor implements FindByIdAttendanceOperation {
    private final AttendanceRepository attendanceRepository;

    @Override
    public FindByIdAttendanceResponse process(final FindByIdAttendanceRequest request) {
        log.info("Processing find by ID attendance request: {}", request);

        String id = request.getId();

        log.debug("Fetching attendance with ID: {}", id);

        Attendance attendance = attendanceRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> {
                    log.error("Attendance not found for ID: {}", id);
                    return new AttendanceNotFoundException();
                });

        log.debug("Fetched attendance: {}", attendance);

        log.info("Returning attendance with ID: {}", id);

        return FindByIdAttendanceResponse.builder()
                .id(String.valueOf(attendance.getId()))
                .checkInTime(String.valueOf(attendance.getCheckInTime()))
                .checkOutTime(String.valueOf(attendance.getCheckOutTime()))
                .employeeId(String.valueOf(attendance.getEmployeeId()))
                .build();
    }
}
