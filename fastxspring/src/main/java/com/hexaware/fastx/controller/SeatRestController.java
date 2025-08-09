package com.hexaware.fastx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx.dto.SeatDto;
import com.hexaware.fastx.entity.Seat;
import com.hexaware.fastx.service.ISeatService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/seat")
public class SeatRestController {
	@Autowired
	ISeatService service;
	
	@PostMapping("/add")
	public Seat addSeat(@RequestBody @Valid SeatDto dto) {
		log.info("REST API called: Add New Seat");
		return service.addSeat(dto);
	}
	
	@GetMapping("/getbyid/{seatId}")
	public Seat getSeatById(@PathVariable int seatId) {
		log.info("REST API called: Get Seat by Id:{}", seatId);
		return service.getSeatId(seatId);
	}
	
	@GetMapping("/getschedule/{scheduleId}")
	public List<Seat> getSeatBySchedule(@PathVariable int scheduleId){
		log.info("REST API called: Get Seat by Schedule Id:{}",scheduleId);
		return service.getSeatBySchedule(scheduleId);
	}
	
	@PutMapping("/release/{seatId}")
	public Seat releaseSeat(@PathVariable int seatId) {
		return service.releaseSeat(seatId);
	}
	
	
}
