package com.ems.logger_service.core.processors;

import com.ems.logger_service.persistence.entities.EmployeeEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeEventConsumer {
    @KafkaListener(topics = "employee-events-topic", groupId = "logger-service-group")
    public void processEmployeeEvent(EmployeeEvent event) {
        // Process and store the event in the Logger service's database
    }
}
