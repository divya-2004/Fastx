package com.hexaware.fastx.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	List<Payment> findByBooking_BookingId(int bookingId);
	

}
