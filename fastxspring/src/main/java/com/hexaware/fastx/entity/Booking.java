package com.hexaware.fastx.entity;

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
public class Booking {
	@Id
	private int bookingId;
	

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="schedule_id")
	private Schedule schedule;
	
	private String seatNumber;
	private String passengerName;
	private Gender passengerGender;
	private double totalAmount;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="seat_id")
	private Seat seat;
	
	private BookingStatus bookingStatus=BookingStatus.Pending;
	
	public enum Gender{
		Male, Female, Other
	}
	public enum BookingStatus{
		Confirmed, Cancelled, Pending
	}

	
}
