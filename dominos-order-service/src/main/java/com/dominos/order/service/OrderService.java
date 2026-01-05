package com.dominos.order.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dominos.order.dto.OrderRequestDTO;
import com.dominos.order.dto.OrderResponseDTO;

public interface OrderService {

	// POST
	String placeOrder(OrderRequestDTO dto, MultipartFile file);

	String placeMultipleOrders(List<OrderRequestDTO> orders);

	// PUT
	String updateOrder(Long orderId, OrderRequestDTO dto);

	// PATCH
	String updateOrderStatus(Long orderId, String status);

	// GET
	OrderResponseDTO getOrderById(Long orderId);

	List<OrderResponseDTO> getAllOrders();

	// DELETE
	String deleteOrder(Long orderId);

	String deleteAllOrders();
}
