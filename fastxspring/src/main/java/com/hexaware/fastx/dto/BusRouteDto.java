package com.hexaware.fastx.dto;

import com.hexaware.fastx.entity.BusRoute.BusType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data 
public class BusRouteDto {
	
	@NotNull(message="Route Id is required")
	private Integer routeId;
	
	@NotNull(message="Operator Id is required")
	private Integer operatorId;
	
	@NotBlank(message="Bus name cannot be empty")
	private String busName;
	
	@NotBlank(message="Bus name cannot be empty")
	private String busNumber;
	
	@NotNull(message="Bus Type cannot be empty")
	private BusType busType;
	
	@NotBlank(message="Orgin cannot be empty")
	private String orgin;
	
	@NotBlank(message="Desitination cannot be empty")
	private String destination;
	
	@Min(value=1)
	private Integer totalSeats;
	
	private double fare;
	private String amenities;
}
