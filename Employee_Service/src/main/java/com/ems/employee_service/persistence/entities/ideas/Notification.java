package com.ems.employee_service.persistence.entities.ideas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private String message;
    private boolean read;

    // Getters and setters
}

//    public Notification createNotification(Long employeeId, String message) {
//        Notification notification = new Notification();
//        notification.setEmployeeId(employeeId);
//        notification.setMessage(message);
//        notification.setRead(false);
//        return notificationRepository.save(notification);
//    }
//
//    public void markNotificationAsRead(Long notificationId) {
//        Notification notification = notificationRepository.findById(notificationId).orElse(null);
//        if (notification != null) {
//            notification.setRead(true);
//            notificationRepository.save(notification);
//        }
//    }