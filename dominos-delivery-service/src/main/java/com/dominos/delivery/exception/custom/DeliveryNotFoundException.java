package com.dominos.delivery.exception.custom;

public class DeliveryNotFoundException extends RuntimeException {

	public DeliveryNotFoundException(String message) {
		super(message);
	}
}
