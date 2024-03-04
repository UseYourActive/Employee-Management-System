package com.ems.leave_service.core.converters;

import com.ems.leave_service.api.operations.LeaveResponseDTO;
import com.ems.leave_service.persistence.entities.Leave;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LeaveResponseDTOConverter implements Converter<Leave, LeaveResponseDTO> {
    @Override
    public LeaveResponseDTO convert(Leave source) {
        return LeaveResponseDTO.builder()
                .id(String.valueOf(source.getId()))
                .employeeId(String.valueOf(source.getEmployeeId()))
                .status(String.valueOf(source.getStatus()))
                .leaveType(String.valueOf(source.getLeaveType()))
                .startDate(String.valueOf(source.getStartDate()))
                .endDate(String.valueOf(source.getEndDate()))
                .build();
    }
}
