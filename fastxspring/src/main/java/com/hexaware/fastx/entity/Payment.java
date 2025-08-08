package com.hexaware.fastx.entity;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Payment {
	@Id
	private int paymentId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "booking_id")  
	private Booking booking;

	private double amount;
	private PaymentStatus paymentStatus=PaymentStatus.Pending;
	private LocalDateTime paymentDate=LocalDateTime.now();
	private String transactionId;
	private String refundTransactionId;
	private LocalDateTime refundDate;
	
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="admin_id")
	private Administrator refundedByAdmin;
	
	public enum PaymentStatus{
		Completed, Pending, Failed, Refunded
	}
}
