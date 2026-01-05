package com.dominos.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dominos.payment.dto.PaymentRequestDTO;
import com.dominos.payment.dto.PaymentStatusUpdateDTO;
import com.dominos.payment.entity.Payment;
import com.dominos.payment.service.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService service;

	// 1️ Create Payment (PENDING)
	@PostMapping
	public ResponseEntity<Payment> makePayment(@Valid @RequestBody PaymentRequestDTO dto) {
		return new ResponseEntity<>(service.makePayment(dto), HttpStatus.CREATED);
	}

	// 2️ Update Payment Status (SUCCESS / FAILED)
	@PutMapping("/{id}/status")
	public ResponseEntity<Payment> updateStatus(@PathVariable Long id, @Valid @RequestBody PaymentStatusUpdateDTO dto) {

		return ResponseEntity.ok(service.updatePaymentStatus(id, dto.getStatus()));
	}

	// 3️ Get Payment
	@GetMapping("/{id}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long id) {
		return ResponseEntity.ok(service.getPaymentById(id));
	}
}
