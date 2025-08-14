package com.hexaware.fastx.entity;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Schedule {
	@Id
	private int scheduleId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="route_id")
	private BusRoute route;
	
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	
	private int availableSeats;
	
	@OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
	@JsonManagedReference
    private List<Seat> seats;

}
