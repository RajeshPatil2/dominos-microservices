package com.dominos.delivery.dto;

import jakarta.validation.constraints.NotBlank;

public class DeliveryStatusUpdateDTO {

	@NotBlank
	private String status; // OUT_FOR_DELIVERY, DELIVERED

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
