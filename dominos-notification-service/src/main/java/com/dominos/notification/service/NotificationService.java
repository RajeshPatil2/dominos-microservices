package com.dominos.notification.service;

import java.util.List;

import com.dominos.notification.entity.Notification;

public interface NotificationService {

	Notification sendNotification(Notification notification);

	Notification getNotificationById(Long id);

	List<Notification> getAllNotifications();
}
