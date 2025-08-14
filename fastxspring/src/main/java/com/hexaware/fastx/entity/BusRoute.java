package com.hexaware.fastx.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Route")
@Data
@NoArgsConstructor
public class BusRoute {
	
	@Id
	private int routeId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="operator_id")
	private BusOperator operatorId;
	
	private String busName;
	private String busNumber;
	public BusType busType;
	private String orgin;
	private String destination;
	private int totalSeats;
	private double fare;
	private String amenities;
	
	public enum BusType{Sleeper_AC, Sleeper_Non_AC, Seater_AC, Seater_Non_AC}

}
