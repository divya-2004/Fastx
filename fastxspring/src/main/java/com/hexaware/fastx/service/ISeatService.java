package com.hexaware.fastx.service;
import java.util.List;

import com.hexaware.fastx.dto.SeatDto;
import com.hexaware.fastx.entity.Seat;

public interface ISeatService {
	public Seat addSeat(SeatDto dto);
	public Seat getSeatId(int seatId);
	public List<Seat> getSeatBySchedule(int scheduleId);
	public Seat bookSeat(int seatId, int bookingId);
	public Seat releaseSeat(int seatId);
	
}
