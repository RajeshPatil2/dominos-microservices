package com.dominos.payment.dto;

import jakarta.validation.constraints.NotBlank;

public class PaymentStatusUpdateDTO {

	@NotBlank
	private String status; // SUCCESS or FAILED

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
