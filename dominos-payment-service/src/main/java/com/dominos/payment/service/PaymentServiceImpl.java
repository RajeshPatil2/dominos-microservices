package com.dominos.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominos.payment.dto.PaymentRequestDTO;
import com.dominos.payment.entity.Payment;
import com.dominos.payment.exception.custom.PaymentNotFoundException;
import com.dominos.payment.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository repository;

	@Override
	public Payment makePayment(PaymentRequestDTO dto) {

		Payment payment = new Payment();
		payment.setOrderId(dto.getOrderId());
		payment.setUserId(dto.getUserId());
		payment.setAmount(dto.getAmount());
		payment.setPaymentMode(dto.getPaymentMode());
		payment.setStatus("PENDING");

		return repository.save(payment);
	}

	@Override
	public Payment updatePaymentStatus(Long paymentId, String status) {

		Payment payment = getPaymentById(paymentId);
		payment.setStatus(status);
		return repository.save(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new PaymentNotFoundException("Payment not found with id: " + id));
	}
}
