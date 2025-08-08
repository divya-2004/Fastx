package com.hexaware.fastx.service;
import java.util.List;

import com.hexaware.fastx.dto.BookingDto;
import com.hexaware.fastx.entity.Booking;

public interface IBookingService {
	public Booking createBooking(BookingDto dto);
	public Booking getBookingByBookingId(int bookingId);
	public List<Booking> getBookingByUserId(int userId);
	public String cancelBooking(int bookingId);
	public List<Booking> getAllBooking();
}
