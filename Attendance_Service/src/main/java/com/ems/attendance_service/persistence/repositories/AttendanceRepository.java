package com.ems.attendance_service.persistence.repositories;

import com.ems.attendance_service.persistence.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttendanceRepository extends JpaRepository<Attendance, UUID> {
}
