package com.ems.attendance_service.api.operations;

import com.ems.attendance_service.api.base.OperationInput;
import com.ems.attendance_service.api.base.OperationOutput;
import com.ems.attendance_service.api.base.OperationProcessor;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


public interface CreateNewAttendanceOperation extends OperationProcessor<CreateNewAttendanceOperation.CreateNewAttendanceResponse, CreateNewAttendanceOperation.CreateNewAttendanceRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class CreateNewAttendanceResponse implements OperationOutput {
        private String id;
        private String employeeId;
        private String checkInTime;
        private String checkOutTime;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class CreateNewAttendanceRequest implements OperationInput {
        private String employeeId;
        private String checkInTime;
        private String checkOutTime;
    }
}
