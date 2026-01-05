package com.dominos.notification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominos.notification.entity.Notification;
import com.dominos.notification.exception.custom.NotificationNotFoundException;
import com.dominos.notification.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationRepository repository;

	@Override
	public Notification sendNotification(Notification notification) {
		notification.setStatus("SENT");
		return repository.save(notification);
	}

	@Override
	public Notification getNotificationById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotificationNotFoundException("Notification not found with id: " + id));
	}

	@Override
	public List<Notification> getAllNotifications() {
		return repository.findAll();
	}
}
