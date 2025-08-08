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
public class Seat {

    @Id
    private int seatId;

    private String seatNumber;

    private boolean isBooked = false;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "booking_id", unique = true)
    private Booking booking;

    
}
