package com.hexaware.fastx.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class SeatDto {
    private int seatId;
    private String seatNumber;
    private boolean isBooked;
    
    private int scheduleId; 
}
