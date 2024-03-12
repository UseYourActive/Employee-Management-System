package com.ems.attendance_service.core.processors;

import com.ems.attendance_service.api.operations.FindAllAttendancesOperation;
import com.ems.attendance_service.persistence.entities.Attendance;
import com.ems.attendance_service.persistence.repositories.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class FindAllAttendancesOperationProcessor implements FindAllAttendancesOperation {
    private final AttendanceRepository attendanceRepository;

    @Override
    public FindAllAttendancesResponse process(final FindAllAttendancesRequest request) {
        log.info("Processing find all attendances request: {}", request);

        PageRequest pageRequest = PageRequest.of(
                request.getPageNumber(),
                request.getNumberOfAttendancesPerPage());

        log.debug("Fetching attendances from repository with page request: {}", pageRequest);

        List<FindAllAttendancesResponseDTO> list = attendanceRepository.findAll(pageRequest)
                .stream()
                .map(this::map)
                .toList();

        log.debug("Fetched {} attendances", list.size());

        log.info("Returning response with {} attendances", list.size());

        return FindAllAttendancesResponse.builder()
                .findAllAttendancesResponseDTOS(list)
                .build();
    }

    private FindAllAttendancesResponseDTO map(Attendance attendance) {
        return FindAllAttendancesResponseDTO.builder()
                .id(String.valueOf(attendance.getId()))
                .checkInTime(String.valueOf(attendance.getCheckInTime()))
                .checkOutTime(String.valueOf(attendance.getCheckOutTime()))
                .employeeId(String.valueOf(attendance.getEmployeeId()))
                .build();
    }
}
