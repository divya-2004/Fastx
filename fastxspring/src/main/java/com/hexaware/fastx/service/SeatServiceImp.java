package com.hexaware.fastx.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.entity.Seat;
import com.hexaware.fastx.repository.SeatRepository;

@Service
public class SeatServiceImp implements ISeatService{
	@Autowired
	SeatRepository repo;
	
	@Override
	public Seat addSeat(Seat seat) {
		return repo.save(seat);
	}
	@Override
	public Seat getSeatId(int seatId) {
		return repo.findById(seatId).orElse(null);
	}
	@Override
	public List<Seat> getSeatBySchedule(int scheduleId){
		return repo.findBySchedule_ScheduleId(scheduleId);
	}
	@Override
	public Seat bookSeat(int seatId, int bookingId) {
		Seat seat=repo.findById(seatId).orElse(null);
		if(seat != null && !seat.isBooked()) {
			seat.setBooked(true);
		return repo.save(seat);
		}
		return seat;
	}
	@Override
	public Seat releaseSeat(int seatId) {
		Seat seat=repo.findById(seatId).orElse(null);
		if(seat != null && seat.isBooked()) {
			seat.setBooked(false);
		return repo.save(seat);
		}
		return seat;
	}
	
}
