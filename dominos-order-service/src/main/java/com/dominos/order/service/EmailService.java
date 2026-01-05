package com.dominos.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendOrderConfirmation(String to, Long orderId) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(to);
			message.setSubject("Domino's Order Confirmed ✅");
			message.setText("Hello Customer,\n\n" + "Your order has been placed successfully.\n" + "Order ID: "
					+ orderId + "\n\n" + "Thank you for ordering from Domino's 🍕");

			mailSender.send(message);

		} catch (Exception e) {
			throw new RuntimeException("Email sending failed: " + e.getMessage());
		}
	}
}
