package com.ems.logger_service.persistence.repositories;

import com.ems.logger_service.persistence.entities.EmployeeEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeEventRepository extends JpaRepository<EmployeeEvent, UUID> {
}
