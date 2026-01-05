package com.dominos.order.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrderRequestDTO {

	@NotBlank(message = "Customer name is required")
	private String customerName;

	@NotBlank(message = "Customer email is required")
	@Email(message = "Invalid email format")
	private String customerEmail;

	@NotBlank(message = "Customer mobile is required")
	private String customerMobile;

	@NotBlank(message = "Order type is required")
	private String orderType; // ONLINE / COD

	@NotNull(message = "Total amount is required")
	@Min(value = 100, message = "Minimum order amount is 100")
	private Double totalAmount;

	// getters & setters
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
