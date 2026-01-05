package com.dominos.order.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.dominos.order.dto.OrderRequestDTO;
import com.dominos.order.dto.OrderResponseDTO;
import com.dominos.order.entity.Order;
import com.dominos.order.exception.custom.OrderNotFoundException;
import com.dominos.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repo;

	@Autowired
	private EmailService emailService;

	private final RestTemplate restTemplate = new RestTemplate();

	// 1️ Place single order
	@Override
	@Transactional
	public String placeOrder(OrderRequestDTO dto, MultipartFile file) {

		try {
			Order order = mapToEntity(dto);

			// File upload
			if (file != null && !file.isEmpty()) {
				order.setInvoiceFile(file.getBytes());
				order.setFileName(file.getOriginalFilename());
				order.setFileType(file.getContentType());
			}

			Order saved = repo.save(order);

			// Email
			emailService.sendOrderConfirmation(
					saved.getCustomerEmail(), saved.getOrderId());

			// Microservice call (Payment)
			String url = "http://localhost:8082/payment/initiate/" + saved.getOrderId();
			restTemplate.getForObject(url, String.class);

			return "Order placed successfully. Order ID: " + saved.getOrderId();

		} catch (Exception e) {
			throw new RuntimeException("Order placement failed");
		}
	}

	// 2️ Place multiple orders
	@Override
	@Transactional
	public String placeMultipleOrders(List<OrderRequestDTO> orders) {

		List<Order> orderList = orders.stream()
				.map(this::mapToEntity)
				.collect(Collectors.toList());

		repo.saveAll(orderList);
		return "Multiple orders placed successfully";
	}

	// 3️ Update full order
	@Override
	@Transactional
	public String updateOrder(Long orderId, OrderRequestDTO dto) {

		Order order = repo.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("Order not found"));

		order.setCustomerName(dto.getCustomerName());
		order.setCustomerEmail(dto.getCustomerEmail());
		order.setCustomerMobile(dto.getCustomerMobile());
		order.setOrderType(dto.getOrderType());
		order.setTotalAmount(dto.getTotalAmount());

		repo.save(order);
		return "Order updated successfully";
	}

	// 4️ Update order status (PATCH)
	@Override
	@Transactional
	public String updateOrderStatus(Long orderId, String status) {

		Order order = repo.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("Order not found"));

		order.setOrderStatus(status);
		repo.save(order);

		return "Order status updated";
	}

	// 5️ Get single order
	@Override
	public OrderResponseDTO getOrderById(Long orderId) {

		Order order = repo.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("Order not found"));

		return mapToResponse(order);
	}

	// 6️ Get all orders
	@Override
	public List<OrderResponseDTO> getAllOrders() {

		return repo.findAll()
				.stream()
				.map(this::mapToResponse)
				.collect(Collectors.toList());
	}

	// 7️ Delete single order
	@Override
	@Transactional
	public String deleteOrder(Long orderId) {

		if (!repo.existsById(orderId)) {
			throw new OrderNotFoundException("Order not found");
		}

		repo.deleteById(orderId);
		return "Order deleted successfully";
	}

	// 8️ Delete all orders
	@Override
	@Transactional
	public String deleteAllOrders() {

		repo.deleteAll();
		return "All orders deleted successfully";
	}

	// ======================
	// Helper methods
	// ======================

	private Order mapToEntity(OrderRequestDTO dto) {

		Order order = new Order();
		order.setCustomerName(dto.getCustomerName());
		order.setCustomerEmail(dto.getCustomerEmail());
		order.setCustomerMobile(dto.getCustomerMobile());
		order.setOrderType(dto.getOrderType());
		order.setTotalAmount(dto.getTotalAmount());

		order.setOrderStatus("PLACED");
		order.setOrderDate(LocalDate.now());
		order.setCreatedAt(LocalDateTime.now());

		return order;
	}

	private OrderResponseDTO mapToResponse(Order order) {

		OrderResponseDTO dto = new OrderResponseDTO();
		dto.setOrderId(order.getOrderId());
		dto.setCustomerName(order.getCustomerName());
		dto.setCustomerEmail(order.getCustomerEmail());
		dto.setOrderStatus(order.getOrderStatus());
		dto.setTotalAmount(order.getTotalAmount());
		dto.setOrderDate(order.getOrderDate());

		return dto;
	}
}
