package com.hexaware.fastx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx.dto.BookingDto;
import com.hexaware.fastx.entity.Booking;
import com.hexaware.fastx.service.IBookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/booking")
public class BookingRestController {
	@Autowired 
	IBookingService service;
	
	@PostMapping("/create")
	public Booking createBooking(@RequestBody @Valid BookingDto dto) {
		return service.createBooking(dto);
	}
	
	@GetMapping("/getbyid/{bookingId}")
	public Booking getBookingById(@PathVariable int bookingId){
		return service.getBookingByBookingId(bookingId);
	}
	
	@GetMapping("/getbyuser/{userId}")
	public List<Booking> getBookingByUser(@PathVariable int userId){
		return service.getBookingByUserId(userId);
	}
	
	@DeleteMapping("/cancel/{bookingId}")
	public String cancelBooking(@PathVariable int bookingId) {
		return service.cancelBooking(bookingId);
	}
	
	@GetMapping("/getall")
	public List<Booking> getAllBooking(){
		return service.getAllBooking();
	}
}
