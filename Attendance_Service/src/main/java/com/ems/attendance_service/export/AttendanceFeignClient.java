package com.ems.attendance_service.export;

import com.ems.attendance_service.api.operations.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ems.attendance_service.api.operations.CreateNewAttendanceOperation.*;
import static com.ems.attendance_service.api.operations.DeleteAttendanceOperation.*;
import static com.ems.attendance_service.api.operations.EditAttendanceOperation.*;
import static com.ems.attendance_service.api.operations.FindAllAttendancesOperation.*;
import static com.ems.attendance_service.api.operations.FindByIdAttendanceOperation.*;

@FeignClient(name = "ATTENDANCE-SERVICE")
public interface AttendanceFeignClient {
    @GetMapping(path = "/attendance/{id}")
    ResponseEntity<FindByIdAttendanceResponse> findAttendanceById(@PathVariable(value = "id") String id);

    @GetMapping(path = "/attendance/find-all")
    ResponseEntity<FindAllAttendancesResponse> findAllAttendances(@RequestParam(defaultValue = "1") Integer pageNumber,
                                                                  @RequestParam(defaultValue = "2") Integer numberOfBooksPerPage);

    @PostMapping(path = "/attendance/create")
    ResponseEntity<CreateNewAttendanceResponse> createNewAttendance(@RequestBody CreateNewAttendanceRequest request);

    @PatchMapping(path = "/attendance/edit")
    ResponseEntity<EditAttendanceResponse> editAttendance(@RequestBody EditAttendanceRequest request);

    @DeleteMapping(path = "/attendance/{id}")
    ResponseEntity<DeleteAttendanceResponse> deleteAttendance(@PathVariable("id") String id);
}
