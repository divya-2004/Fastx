package com.hexaware.fastx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.dto.BookingDto;
import com.hexaware.fastx.entity.Booking;
import com.hexaware.fastx.entity.Schedule;
import com.hexaware.fastx.entity.Seat;
import com.hexaware.fastx.entity.User;
import com.hexaware.fastx.exception.BookingException;
import com.hexaware.fastx.exception.ResourceNotFoundException;
import com.hexaware.fastx.repository.BookingRepository;
import com.hexaware.fastx.repository.ScheduleRepository;
import com.hexaware.fastx.repository.SeatRepository;
import com.hexaware.fastx.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class BookingServiceImp implements IBookingService{
	@Autowired
	BookingRepository repo;
	
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ScheduleRepository scheduleRepo;
	
	@Autowired
	SeatRepository seatRepo;
	
	@Override
	public Booking createBooking(BookingDto dto) {
		log.info("Creating new booking:{}(User Id:{})", dto.getPassengerName(), dto.getUserId());
		
		Booking booking= new Booking();
		booking.setBookingId(dto.getBookingId());
		booking.setPassengerName(dto.getPassengerName());
		booking.setPassengerGender(Booking.Gender.valueOf(dto.getPassengerGender()));
		booking.setSeatNumber(dto.getSeatNumber());
		booking.setTotalAmount(dto.getTotalAmount());
		booking.setBookingStatus(Booking.BookingStatus.valueOf(dto.getBookingStatus()));
		
		User user=userRepo.findById(dto.getUserId()).orElseThrow(()->new ResourceNotFoundException("User Not Found:{}"+dto.getUserId()));
		booking.setUser(user);
		
		Schedule schedule=scheduleRepo.findById(dto.getScheduleId()).orElseThrow(()->new ResourceNotFoundException("Schedule Not Found:{}"+dto.getScheduleId()));
		booking.setSchedule(schedule);
		
		Seat seat= seatRepo.findById(dto.getSeatId()).orElseThrow(()->new ResourceNotFoundException("Seat Not Found:{}"+dto.getSeatId()));
		booking.setSeat(seat);
		
		if(seat.isBooked()) {throw new BookingException("Seat already booked");}
		
		return repo.save(booking);
	}
	@Override
	public Booking getBookingByBookingId(int bookingId) {
		log.debug("Get booking by Id:{}", bookingId);
		return repo.findById(bookingId).orElse(null);
	}
	@Override
	public List<Booking> getBookingByUserId(int userId) {
		log.debug("Get booking by user Id:{}", userId);
		return repo.findByUser_UserId(userId);
	}	
	@Override
	public String cancelBooking(int bookingId) {
		log.info("Cancel booking by Id:{}", bookingId);
		repo.deleteById(bookingId);
		return "Booking Cancelled Successfully";
	}
	@Override
	public List<Booking> getAllBooking(){
		log.debug("Get all bookings");
		return repo.findAll();
	}

}
