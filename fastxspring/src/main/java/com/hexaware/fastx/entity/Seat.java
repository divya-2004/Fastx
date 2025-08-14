package com.hexaware.fastx.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Seat {
    @Id
    private int seatId;
    private String seatNumber;
    private boolean isBooked;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    @JsonBackReference
    private Schedule schedule;
}
