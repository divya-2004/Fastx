package com.hexaware.fastx.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.dto.SeatDto;
import com.hexaware.fastx.entity.Booking;
import com.hexaware.fastx.entity.Schedule;
import com.hexaware.fastx.entity.Seat;
import com.hexaware.fastx.repository.BookingRepository;
import com.hexaware.fastx.repository.ScheduleRepository;
import com.hexaware.fastx.repository.SeatRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class SeatServiceImp implements ISeatService{
	@Autowired
	SeatRepository repo;
	
	@Autowired
	ScheduleRepository scheduleRepo;
	
	@Autowired
	BookingRepository bookingRepo;
	
	@Override
	public Seat addSeat(SeatDto dto) {
		log.info("Add Seat Info");
		Seat seat=new Seat();
		seat.setSeatId(dto.getSeatId());
		seat.setSeatNumber(dto.getSeatNumber());
		seat.setBooked(dto.isBooked());
		
		Schedule schedule=scheduleRepo.findById(dto.getScheduleId()).orElse(null);
		seat.setSchedule(schedule);
		
		Booking booking=bookingRepo.findById(dto.getBookingId()).orElse(null);
		seat.setBooking(booking);
		
		return repo.save(seat);
		
	}
	@Override
	public Seat getSeatId(int seatId) {
		log.info("Get Seat by Id:{}",seatId);
		return repo.findById(seatId).orElse(null);
	}
	@Override
	public List<Seat> getSeatBySchedule(int scheduleId){
		log.info("Get Seat by Schedule Id:{}",scheduleId);
		return repo.findBySchedule_ScheduleId(scheduleId);
	}
	@Override
	public Seat bookSeat(int seatId, int bookingId) {
		log.info("Book a Seat");
		Seat seat=repo.findById(seatId).orElse(null);
		if(seat != null && !seat.isBooked()) {
			seat.setBooked(true);
		return repo.save(seat);
		}
		return seat;
	}
	@Override
	public Seat releaseSeat(int seatId) {
		log.info("Confirm Seat",seatId);
		Seat seat=repo.findById(seatId).orElse(null);
		if(seat != null && seat.isBooked()) {
			seat.setBooked(false);
		return repo.save(seat);
		}
		return seat;
	}
	
}
