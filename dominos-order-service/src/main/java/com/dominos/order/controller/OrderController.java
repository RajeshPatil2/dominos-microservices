package com.dominos.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dominos.order.dto.OrderRequestDTO;
import com.dominos.order.dto.OrderResponseDTO;
import com.dominos.order.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService service;

	// 1️ POST – Single Order (Multipart: JSON + File)
	@PostMapping(value = "/post", consumes = "multipart/form-data")
	public ResponseEntity<String> placeOrder(@Valid @RequestPart("order") OrderRequestDTO dto,
			@RequestPart("file") MultipartFile file) {

		return ResponseEntity.ok(service.placeOrder(dto, file));
	}

	// 2️ POST – Multiple Orders (Bulk insert)
	@PostMapping("/bulk")
	public ResponseEntity<String> placeMultipleOrders(@Valid @RequestBody List<OrderRequestDTO> orders) {

		return ResponseEntity.ok(service.placeMultipleOrders(orders));
	}

	// 3️ PUT – Update complete order (single)
	@PutMapping("/{id}")
	public ResponseEntity<String> updateOrder(@PathVariable Long id, @Valid @RequestBody OrderRequestDTO dto) {

		return ResponseEntity.ok(service.updateOrder(id, dto));
	}

	// 4️ PATCH – Update order status only
	@PatchMapping("/{id}/status")
	public ResponseEntity<String> updateOrderStatus(@PathVariable Long id, @RequestParam String status) {

		return ResponseEntity.ok(service.updateOrderStatus(id, status));
	}

	// 5️ GET – Get single order by ID
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long id) {

		return ResponseEntity.ok(service.getOrderById(id));
	}

	// 6️ GET – Get all orders
	@GetMapping
	public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {

		return ResponseEntity.ok(service.getAllOrders());
	}

	// 7️ DELETE – Delete single order
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long id) {

		return ResponseEntity.ok(service.deleteOrder(id));
	}

	// 8️ DELETE – Delete all orders
	@DeleteMapping("/all")
	public ResponseEntity<String> deleteAllOrders() {

		return ResponseEntity.ok(service.deleteAllOrders());
	}
}
