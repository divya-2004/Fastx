package com.hexaware.fastx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"user", "schedule", "seat"})
public class Booking {
    @Id
    private int bookingId;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name="schedule_id")
    @JsonIgnore
    private Schedule schedule;

    private String seatNumber;
    private String passengerName;
    private Gender passengerGender;
    private double totalAmount;

    @OneToOne
    @JoinColumn(name="seat_id")
    @JsonIgnore
    private Seat seat;

    private BookingStatus bookingStatus = BookingStatus.Pending;

    public enum Gender {
        Male, Female, Other
    }

    public enum BookingStatus {
        Confirmed, Cancelled, Pending
    }
}
