package com.dominos.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dominos.notification.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
