package com.ems.attendance_service.api.operations;

import com.ems.attendance_service.api.base.OperationInput;
import com.ems.attendance_service.api.base.OperationOutput;
import com.ems.attendance_service.api.base.OperationProcessor;
import lombok.*;

public interface FindByIdAttendanceOperation extends OperationProcessor<FindByIdAttendanceOperation.FindByIdAttendanceResponse, FindByIdAttendanceOperation.FindByIdAttendanceRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindByIdAttendanceResponse implements OperationOutput {

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindByIdAttendanceRequest implements OperationInput {
        private String id;
    }
}
