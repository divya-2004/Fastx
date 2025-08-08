package com.hexaware.fastx.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data 
public class SeatDto {

	@NotNull(message ="Seat ID is required")
	private int seatId;

	@NotNull(message ="Seat No is required")
	@Pattern(regexp="[A-Z][0-9]{2,2}")
    private String seatNumber;

    private boolean booked = false;

    @NotNull(message ="Schedule ID is required")
    private int scheduleId;

    
    private int bookingId;
}
