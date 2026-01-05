package com.dominos.delivery.service;

import java.util.List;

import com.dominos.delivery.dto.DeliveryRequestDTO;
import com.dominos.delivery.entity.Delivery;

public interface DeliveryService {

	Delivery assignDelivery(DeliveryRequestDTO dto);

	Delivery updateDeliveryStatus(Long deliveryId, String status);

	Delivery getDeliveryById(Long id);

	List<Delivery> getAllDeliveries();
}
