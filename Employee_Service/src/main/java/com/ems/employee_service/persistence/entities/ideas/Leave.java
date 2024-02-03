package com.ems.employee_service.persistence.entities.ideas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean approved;

    public Leave() {
    }

    // Getters and setters
}

//    List<Leave> findByApproved(boolean approved);
//
//    public Leave requestLeave(Long employeeId, LocalDate startDate, LocalDate endDate) {
//        Leave leave = new Leave();
//        leave.setEmployeeId(employeeId);
//        leave.setStartDate(startDate);
//        leave.setEndDate(endDate);
//        leave.setApproved(false);
//        return leaveRepository.save(leave);
//    }
//
//    public Leave approveLeave(Long leaveId) {
//        Leave leave = leaveRepository.findById(leaveId).orElse(null);
//        if (leave != null && !leave.isApproved()) {
//            leave.setApproved(true);
//            return leaveRepository.save(leave);
//        }
//        return null; // Leave not found or already approved
//    }