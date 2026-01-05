package com.dominos.payment.service;

import com.dominos.payment.dto.PaymentRequestDTO;
import com.dominos.payment.entity.Payment;

public interface PaymentService {

	Payment makePayment(PaymentRequestDTO dto);

	Payment updatePaymentStatus(Long paymentId, String status);

	Payment getPaymentById(Long id);
}
