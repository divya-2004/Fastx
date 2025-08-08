package com.hexaware.fastx.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.entity.Payment;
import com.hexaware.fastx.repository.PaymentRepository;

@Service
public class PaymentServiceImp implements IPaymentService{
	@Autowired
	PaymentRepository repo;
	
	@Override
	public Payment makePayment(Payment payment) {
		return repo.save(payment);
	}
	@Override
	public Payment getPaymentByPaymentId(int paymentId) {
		return repo.findById(paymentId).orElse(null);
	}
	@Override
	public List<Payment> getPaymentByBookingId(int bookingId){
		return repo.findByBooking_BookingId(bookingId);
	}
	@Override
	public String refundPayment(int paymentId) {
		Payment payment= repo.findById(paymentId).orElse(null);
		if(payment != null) {
			payment.setPaymentStatus(Payment.PaymentStatus.Refunded);
			repo.save(payment);
			return "Payment Refunded Successfully";
		}return "Payment not found";
	}
	@Override 
	public List<Payment> getAllPayment(){
		return repo.findAll();
	}
	
}
