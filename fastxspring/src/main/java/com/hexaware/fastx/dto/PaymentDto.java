package com.hexaware.fastx.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data 
public class PaymentDto {
	
	@NotNull(message="Payment Id cannot be null")
	private int paymentId;
	 
	@NotNull(message="Booking Id cannot be null")
	private int bookingId;

	@Min(value=1)
	private double amount;
	
	private String paymentStatus="Pending";
	private LocalDateTime paymentDate=LocalDateTime.now();
	private String transactionId;
	private String refundTransactionId;
	private LocalDateTime refundDate;
	
	private int adminId;
	
}
