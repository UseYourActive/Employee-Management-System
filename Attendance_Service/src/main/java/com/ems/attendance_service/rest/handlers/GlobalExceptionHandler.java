package com.ems.attendance_service.rest.handlers;

import com.ems.attendance_service.core.exceptions.AttendanceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RestClientException.class)
    @ResponseBody
    public ResponseEntity<String> handleRestClientException(RestClientException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error occurred during API call! " + e.getMessage());
    }

    @ExceptionHandler(AttendanceNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleTrainingNotFoundException(AttendanceNotFoundException e) {
        log.error("Attendance not found", e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found! " + e.getMessage());
    }
}
