package com.ems.attendance_service.api.operations;

import com.ems.attendance_service.api.base.OperationInput;
import com.ems.attendance_service.api.base.OperationOutput;
import com.ems.attendance_service.api.base.OperationProcessor;
import lombok.*;

public interface EditAttendanceOperation extends OperationProcessor<EditAttendanceOperation.EditAttendanceResponse, EditAttendanceOperation.EditAttendanceRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class EditAttendanceResponse implements OperationOutput {

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class EditAttendanceRequest implements OperationInput {

    }
}
