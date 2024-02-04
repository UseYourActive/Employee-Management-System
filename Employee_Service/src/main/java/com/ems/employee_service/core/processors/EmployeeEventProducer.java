package com.ems.employee_service.core.processors;

import com.ems.employee_service.persistence.entities.EmployeeEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeEventProducer {
    private KafkaTemplate<String, EmployeeEvent> kafkaTemplate;

    public void sendEmployeeEvent(EmployeeEvent event) {
        kafkaTemplate.send("employee-events-topic", event);
    }
}
