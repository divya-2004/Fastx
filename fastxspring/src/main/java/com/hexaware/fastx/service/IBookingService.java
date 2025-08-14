package com.hexaware.fastx.service;

import java.util.List;
import com.hexaware.fastx.dto.BookingDto;
import com.hexaware.fastx.entity.Booking;

public interface IBookingService {
    Booking createBooking(BookingDto dto);
    Booking getBookingByBookingId(int bookingId);
    List<Booking> getBookingByUserId(int userId);
    List<Booking> getAllBooking();
    String cancelBooking(int bookingId);
}
