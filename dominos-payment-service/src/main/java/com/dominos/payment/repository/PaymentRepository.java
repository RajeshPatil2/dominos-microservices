package com.dominos.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dominos.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
