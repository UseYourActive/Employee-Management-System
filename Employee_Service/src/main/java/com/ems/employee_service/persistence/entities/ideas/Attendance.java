package com.ems.employee_service.persistence.entities.ideas;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;
}

//    public Attendance clockIn(Long employeeId) {
//        Attendance attendance = new Attendance();
//        attendance.setEmployeeId(employeeId);
//        attendance.setClockInTime(LocalDateTime.now());
//        return attendanceRepository.save(attendance);
//    }
//
//    public Attendance clockOut(Long employeeId) {
//        List<Attendance> employeeAttendance = attendanceRepository.findByEmployeeId(employeeId);
//        if (!employeeAttendance.isEmpty()) {
//            Attendance latestAttendance = employeeAttendance.get(employeeAttendance.size() - 1);
//            if (latestAttendance.getClockOutTime() == null) {
//                latestAttendance.setClockOutTime(LocalDateTime.now());
//                return attendanceRepository.save(latestAttendance);
//            }
//        }
//        return null; // Employee has no active clock-in
//    }