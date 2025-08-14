package com.hexaware.fastx.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.dto.PaymentDto;
import com.hexaware.fastx.entity.Administrator;
import com.hexaware.fastx.entity.Booking;
import com.hexaware.fastx.entity.Payment;
import com.hexaware.fastx.repository.AdministratorRepository;
import com.hexaware.fastx.repository.BookingRepository;
import com.hexaware.fastx.repository.PaymentRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 * Payment Service
 * @author Divya
 * Modified: 09/08/2025
 * 
 * 
 *
 */

@Slf4j
@Service
@Transactional
public class PaymentServiceImp implements IPaymentService{
	@Autowired
	PaymentRepository repo;
	
	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	AdministratorRepository adminRepo;
	
	@Override
	public Payment makePayment(PaymentDto dto) {
		log.info("Make a Payment");
		Payment payment=new Payment();
		payment.setPaymentId(dto.getPaymentId());
		
		Administrator admin = adminRepo.findById(dto.getAdminId()).orElse(null);
		payment.setAdmin(admin);

		
		Booking booking=bookingRepo.findById(dto.getBookingId()).orElse(null);
		payment.setBooking(booking);
		payment.setTransactionId(dto.getTransactionId());
		payment.setRefundTransactionId(dto.getRefundTransactionId());
		payment.setPaymentStatus(Payment.PaymentStatus.valueOf(dto.getPaymentStatus()));
		payment.setPaymentDate(dto.getPaymentDate());
		payment.setRefundDate(dto.getRefundDate());
		payment.setAmount(dto.getAmount());
		return repo.save(payment);
	}
	@Override
	public Payment getPaymentByPaymentId(int paymentId) {
		log.debug("Get Payment By Id:{}", paymentId);
		return repo.findById(paymentId).orElse(null);
	}
	@Override
	public List<Payment> getPaymentByBookingId(int bookingId){
		log.debug("Get Payment By Id:{}", bookingId);
		return repo.findByBooking_BookingId(bookingId);
	}
	@Override
	public String refundPayment(int paymentId) {
		log.info("Payment Refund");
		Payment payment= repo.findById(paymentId).orElse(null);
		if(payment != null) {
			payment.setPaymentStatus(Payment.PaymentStatus.Refunded);
			repo.save(payment);
			return "Payment Refunded Successfully";
		}return "Payment not found";
	}
	@Override 
	public List<Payment> getAllPayment(){
		log.debug("Get All Payments");
		return repo.findAll();
	}
	
}
