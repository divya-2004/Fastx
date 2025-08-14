package com.hexaware.fastx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx.dto.SeatDto;
import com.hexaware.fastx.service.ISeatService;

/**
 * Seat Controller
 * @author Divya
 * Modified: 13/08/2025
 * get seats by schedule id
 * get available seats by schedule id
 */


@RestController
@RequestMapping("/api/seats")
public class SeatRestController {

    @Autowired
    private ISeatService seatService;

    @GetMapping("/all/{scheduleId}")
    @PreAuthorize("hasAnyAuthority('Admin')")
    public List<SeatDto> getSeats(@PathVariable int scheduleId) {
        return seatService.getSeatsByScheduleId(scheduleId);
    }

    @GetMapping("/available/{scheduleId}")
    @PreAuthorize("hasAnyAuthority('Admin')")
    public List<SeatDto> getAvailableSeats(@PathVariable int scheduleId) {
        return seatService.getAvailableSeatsByScheduleId(scheduleId);
    }//UPDATE seat SET is_booked = false WHERE seat_id = 1;

}
