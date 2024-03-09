package com.ems.attendance_service.core.processors;

import com.ems.attendance_service.api.operations.DeleteAttendanceOperation;
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
public class DeleteAttendanceOperationProcessor implements DeleteAttendanceOperation {
    private final AttendanceRepository attendanceRepository;

    @Override
    public DeleteAttendanceResponse process(final DeleteAttendanceRequest request) {
        log.info("Processing delete attendance request: {}", request);

        String id = request.getId();

        log.debug("Finding attendance record with ID: {}", id);

        Attendance attendance = attendanceRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> {
                    log.error("Attendance not found with ID: {}", id);
                    return new AttendanceNotFoundException();
                });

        log.debug("Attendance record found: {}", attendance);

        log.debug("Deleting attendance record: {}", attendance);

        attendanceRepository.delete(attendance);

        log.info("Attendance record successfully deleted");

        DeleteAttendanceResponse response = DeleteAttendanceResponse.builder()
                .isSuccessfullyDeleted(Boolean.TRUE)
                .build();

        log.info("Returning response for deleted attendance: {}", response);

        return response;
    }
}
