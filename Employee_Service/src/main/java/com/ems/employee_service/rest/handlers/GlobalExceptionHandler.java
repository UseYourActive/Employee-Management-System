package com.ems.employee_service.rest.handlers;

import com.ems.employee_service.core.exceptions.EmployeeNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RestClientException.class)
    @ResponseBody
    public ResponseEntity<String> handleRestClientException(RestClientException e) {
        log.error("Error occurred during API call", e);
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Error occurred during API call! " + e.getMessage());
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        log.error("Employee not found", e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found! " + e.getMessage());
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseBody
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatusCode status,
//                                                                  WebRequest request) {
//        log.error("Validation error", ex);
//        Map<String, String> errors = new HashMap<>();
//        List<ObjectError> listOfErrors = ex.getBindingResult().getAllErrors();
//
//        listOfErrors.forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String message = error.getDefaultMessage();
//            errors.put(fieldName, message);
//        });
//
//        return ResponseEntity.badRequest().body(errors);
//    }
}
