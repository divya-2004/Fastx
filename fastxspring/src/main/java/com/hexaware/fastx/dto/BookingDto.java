package com.hexaware.fastx.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data 
public class BookingDto {
	@NotNull(message="Booking Id cannot be null")
	private Integer bookingId;
	
	@NotNull(message="User Id cannot be null")
	private Integer userId;
	
	@NotNull(message="Schedule Id cannot be null")
	private Integer scheduleId;
	
	@NotBlank(message="Seat No cannot be null")
	@Pattern(regexp = "^[A-Z][0-9]{1,2}$")
	private String seatNumber;
	
	@NotBlank(message="Name is required")
	private String passengerName;
	
	@NotNull(message="Passenger Gender is required")
	private String passengerGender;
	
	@DecimalMin(value="0.0", inclusive=false)
	private double totalAmount;
	
	@NotNull(message="Seat Id cannot be null")
	private Integer seatId;
	
	private String bookingStatus="Pending";
}

