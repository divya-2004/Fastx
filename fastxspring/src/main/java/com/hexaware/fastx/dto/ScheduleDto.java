package com.hexaware.fastx.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data 
public class ScheduleDto {
	
	@NotNull(message="Schedule Id cannot be null")
	private int scheduleId;
	
	@NotNull(message="Route Id cannot be null")
	private int routeId;
	
	@NotNull(message="Departure Time cannot be null")
	@Future(message="Departure time must be in future")
	private LocalDateTime departureTime;
	
	@NotNull(message="Arrival Timecannot be null")
	@Future(message="Arrival time must be in future")
	private LocalDateTime arrivalTime;
	
	
	private int availableSeats;
	
}
