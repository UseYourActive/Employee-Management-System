package com.ems.leave_service.core.processors;

import com.ems.leave_service.api.operations.LeaveResponseDTO;
import com.ems.leave_service.api.operations.find.leave.all.FindAllLeavesOperation;
import com.ems.leave_service.api.operations.find.leave.all.FindAllLeavesRequest;
import com.ems.leave_service.api.operations.find.leave.all.FindAllLeavesResponse;
import com.ems.leave_service.core.converters.LeaveResponseDTOConverter;
import com.ems.leave_service.persistence.entities.Leave;
import com.ems.leave_service.persistence.repositories.LeaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindAllLeavesOperationProcessor implements FindAllLeavesOperation {
    private final LeaveRepository leaveRepository;
    private final LeaveResponseDTOConverter converter;

    @Override
    public FindAllLeavesResponse process(final FindAllLeavesRequest request) {
        PageRequest pageRequest = PageRequest.of(
                request.getPageNumber(),
                request.getNumberOfBooksPerPage());

        Page<Leave> allLeaves = leaveRepository.findAll(pageRequest);

        List<LeaveResponseDTO> list = allLeaves.stream().map(converter::convert).toList();

        return FindAllLeavesResponse.builder()
                .leaveResponseDTOS(list)
                .build();
    }
}
