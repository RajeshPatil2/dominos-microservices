package com.dominos.notification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dominos.notification.entity.Notification;
import com.dominos.notification.service.NotificationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

	@Autowired
	private NotificationService service;

	// Send notification
	@PostMapping
	public ResponseEntity<Notification> send(@Valid @RequestBody Notification notification) {

		return new ResponseEntity<>(service.sendNotification(notification), HttpStatus.CREATED);
	}

	// Get notification by id
	@GetMapping("/{id}")
	public ResponseEntity<Notification> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getNotificationById(id));
	}

	// Get all notifications
	@GetMapping
	public ResponseEntity<List<Notification>> getAll() {
		return ResponseEntity.ok(service.getAllNotifications());
	}
}
