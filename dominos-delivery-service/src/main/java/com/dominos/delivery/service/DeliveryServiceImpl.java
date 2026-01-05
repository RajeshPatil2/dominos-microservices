package com.dominos.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominos.delivery.dto.DeliveryRequestDTO;
import com.dominos.delivery.entity.Delivery;
import com.dominos.delivery.exception.custom.DeliveryNotFoundException;
import com.dominos.delivery.repository.DeliveryRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private DeliveryRepository repository;

	@Override
	public Delivery assignDelivery(DeliveryRequestDTO dto) {

		Delivery delivery = new Delivery();
		delivery.setOrderId(dto.getOrderId());
		delivery.setUserId(dto.getUserId());
		delivery.setDeliveryAddress(dto.getDeliveryAddress());
		delivery.setDeliveryPerson(dto.getDeliveryPerson());
		delivery.setStatus("ASSIGNED");

		return repository.save(delivery);
	}

	@Override
	public Delivery updateDeliveryStatus(Long id, String status) {

		Delivery delivery = getDeliveryById(id);
		delivery.setStatus(status);
		return repository.save(delivery);
	}

	@Override
	public Delivery getDeliveryById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new DeliveryNotFoundException("Delivery not found with id: " + id));
	}

	@Override
	public List<Delivery> getAllDeliveries() {
		return repository.findAll();
	}
}
