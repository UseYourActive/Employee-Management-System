package com.ems.attendance_service.core.processors;

import com.ems.attendance_service.api.operations.ClockInOperation;
import com.ems.attendance_service.persistence.entities.Attendance;
import com.ems.attendance_service.persistence.repositories.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClockInOperationProcessor implements ClockInOperation {
    private final AttendanceRepository attendanceRepository;
    @Override
    public ClockInResponse process(final ClockInRequest request) {
        String employeeId = request.getEmployeeId();

        Attendance attendance = Attendance.builder()
                .employeeId(UUID.fromString(employeeId))
                .checkInTime(LocalDateTime.now())
                .build();

        Attendance persistedAttendance = attendanceRepository.save(attendance);

       return ClockInResponse.builder()
               .id(String.valueOf(attendance.getId()))
               .clockInTime(String.valueOf(persistedAttendance.getCheckInTime()))
               .employeeId(String.valueOf(persistedAttendance.getEmployeeId()))
               .successfullyClockedIn(Boolean.TRUE)
               .build();
    }
}
