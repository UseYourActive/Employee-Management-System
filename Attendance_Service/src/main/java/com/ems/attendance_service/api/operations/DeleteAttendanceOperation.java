package com.ems.attendance_service.api.operations;

import com.ems.attendance_service.api.base.OperationInput;
import com.ems.attendance_service.api.base.OperationOutput;
import com.ems.attendance_service.api.base.OperationProcessor;
import lombok.*;

public interface DeleteAttendanceOperation extends OperationProcessor<DeleteAttendanceOperation.DeleteAttendanceResponse, DeleteAttendanceOperation.DeleteAttendanceRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class DeleteAttendanceResponse implements OperationOutput {

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class DeleteAttendanceRequest implements OperationInput {
        private String id;
    }
}
