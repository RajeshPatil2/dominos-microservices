package com.dominos.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dominos.delivery.entity.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
