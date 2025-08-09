package com.hexaware.fastx.service;
import java.util.List;

import com.hexaware.fastx.dto.PaymentDto;
import com.hexaware.fastx.entity.Payment;

public interface IPaymentService {
	public Payment makePayment(PaymentDto dto);
	public Payment getPaymentByPaymentId(int paymentId);
	public List<Payment> getPaymentByBookingId(int bookingId);
	public String refundPayment(int paymentId);
	public List<Payment> getAllPayment();
}
