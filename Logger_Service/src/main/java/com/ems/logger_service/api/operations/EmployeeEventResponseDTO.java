package com.ems.logger_service.api.operations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class EmployeeEventResponseDTO {
    private String id;
    private String employeeId;
    private String eventType;
    private String eventDescription;
}
