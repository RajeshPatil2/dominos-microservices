package com.dominos.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.dominos.delivery.dto.DeliveryRequestDTO;
import com.dominos.delivery.dto.DeliveryStatusUpdateDTO;
import com.dominos.delivery.entity.Delivery;
import com.dominos.delivery.service.DeliveryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

	@Autowired
	private DeliveryService service;

	// 1️⃣ Assign Delivery
	@PostMapping
	public ResponseEntity<Delivery> assign(@Valid @RequestBody DeliveryRequestDTO dto) {
		return new ResponseEntity<>(service.assignDelivery(dto), HttpStatus.CREATED);
	}

	// 2️⃣ Update Delivery Status
	@PutMapping("/{id}/status")
	public ResponseEntity<Delivery> updateStatus(
			@PathVariable Long id,
			@Valid @RequestBody DeliveryStatusUpdateDTO dto) {

		return ResponseEntity.ok(service.updateDeliveryStatus(id, dto.getStatus()));
	}

	// 3️⃣ Get Delivery by ID
	@GetMapping("/{id}")
	public ResponseEntity<Delivery> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getDeliveryById(id));
	}

	// 4️⃣ Get All Deliveries
	@GetMapping
	public ResponseEntity<List<Delivery>> getAll() {
		return ResponseEntity.ok(service.getAllDeliveries());
	}
}
