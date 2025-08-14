package com.hexaware.fastx.entity;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"booking", "admin"})
public class Payment {
    @Id
    private int paymentId;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    @JsonIgnore 
    private Booking booking;

    private double amount;
    private PaymentStatus paymentStatus = PaymentStatus.Pending;
    private LocalDateTime paymentDate = LocalDateTime.now();
    private String transactionId;
    private String refundTransactionId;
    private LocalDateTime refundDate;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    @JsonBackReference(value = "admin-payments")
    @JsonIgnoreProperties({"payments"})
    private Administrator admin;

    public enum PaymentStatus {
        Completed, Pending, Failed, Refunded
    }
}
