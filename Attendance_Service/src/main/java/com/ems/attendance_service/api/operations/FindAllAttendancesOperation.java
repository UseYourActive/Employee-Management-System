package com.ems.attendance_service.api.operations;

import com.ems.attendance_service.api.base.OperationInput;
import com.ems.attendance_service.api.base.OperationOutput;
import com.ems.attendance_service.api.base.OperationProcessor;
import lombok.*;

import java.util.List;

public interface FindAllAttendancesOperation extends OperationProcessor<FindAllAttendancesOperation.FindAllAttendancesResponse, FindAllAttendancesOperation.FindAllAttendancesRequest> {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindAllAttendancesResponse implements OperationOutput {
        private List<FindAllAttendancesResponseDTO> findAllAttendancesResponseDTOS;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindAllAttendancesRequest implements OperationInput {
        private Integer pageNumber;
        private Integer numberOfBooksPerPage;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class FindAllAttendancesResponseDTO {
        private String id;
        private String employeeId;
        private String checkInTime;
        private String checkOutTime;
    }
}
