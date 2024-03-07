package com.ems.attendance_service.api.operations;

import com.ems.attendance_service.api.base.OperationInput;
import com.ems.attendance_service.api.base.OperationOutput;
import com.ems.attendance_service.api.base.OperationProcessor;
import lombok.*;


public interface CreateNewAttendanceOperation extends OperationProcessor<CreateNewAttendanceOperation.CreateNewAttendanceResponse, CreateNewAttendanceOperation.CreateNewAttendanceRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class CreateNewAttendanceResponse implements OperationOutput {

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class CreateNewAttendanceRequest implements OperationInput {

    }
}
