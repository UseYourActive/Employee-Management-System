package com.ems.leave_service.core.processors;

import com.ems.leave_service.api.operations.LeaveResponseDTO;
import com.ems.leave_service.api.operations.find.leave.by_start_between_dates.FindByStartBetweenDatesOperation;
import com.ems.leave_service.api.operations.find.leave.by_start_between_dates.FindByStartBetweenDatesRequest;
import com.ems.leave_service.api.operations.find.leave.by_start_between_dates.FindByStartBetweenDatesResponse;
import com.ems.leave_service.core.converters.LeaveResponseDTOConverter;
import com.ems.leave_service.persistence.entities.Leave;
import com.ems.leave_service.persistence.repositories.LeaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindLeaveByStartBetweenDatesOperationProcessor implements FindByStartBetweenDatesOperation {
    private final LeaveRepository leaveRepository;
    private final LeaveResponseDTOConverter converter;

    @Override
    public FindByStartBetweenDatesResponse process(final FindByStartBetweenDatesRequest request) {
        String startDate = request.getStartDate();
        String endDate = request.getEndDate();

        List<Leave> findByStartDateBetween = leaveRepository.findByStartDateBetween(LocalDate.parse(startDate), LocalDate.parse(endDate));

        List<LeaveResponseDTO> list = findByStartDateBetween.stream()
                .map(converter::convert)
                .toList();

        return FindByStartBetweenDatesResponse.builder()
                .leaveResponseDTOS(list)
                .build();
    }
}
