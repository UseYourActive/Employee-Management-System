package com.ems.employee_service.persistence.entities;

import com.ems.employee_service.persistence.enums.EventType;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEvent {
    private UUID employeeId;
    private EventType eventType;
    private String eventDescription;
}
