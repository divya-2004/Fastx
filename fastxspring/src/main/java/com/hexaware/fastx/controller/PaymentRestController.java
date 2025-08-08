package com.hexaware.fastx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx.entity.Payment;
import com.hexaware.fastx.service.IPaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentRestController {
	@Autowired
	IPaymentService service;
	
	@PostMapping("/make")
	public Payment makePayment(@RequestBody Payment payment) {
		return service.makePayment(payment);
	}
	@GetMapping("/getbyid/{paymentId}")
	public Payment getPaymentById(@PathVariable int paymentId) {
		return service.getPaymentByPaymentId(paymentId);
	}
	@GetMapping("/getbybookinf/{bookingId}")
	public List<Payment> getPaymentByBooking(@PathVariable int bookingId) {
		return service.getPaymentByBookingId(bookingId);
	}
	@GetMapping("/getall")
	public List<Payment> getAllPayment(){
		return service.getAllPayment();
	}
	@PutMapping("/refund/{paymentId}")
	public String refundPayment(@PathVariable int paymentId) {
		return service.refundPayment(paymentId);
	}
}
