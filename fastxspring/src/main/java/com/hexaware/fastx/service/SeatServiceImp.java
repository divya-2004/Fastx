package com.hexaware.fastx.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.dto.SeatDto;
import com.hexaware.fastx.repository.SeatRepository;

@Service
public class SeatServiceImp implements ISeatService {

    @Autowired
    private SeatRepository seatRepo;

    @Override
    public List<SeatDto> getSeatsByScheduleId(int scheduleId) {
        return seatRepo.findBySchedule_ScheduleId(scheduleId)
                       .stream()
                       .map(seat -> {
                           SeatDto dto = new SeatDto();
                           dto.setSeatId(seat.getSeatId());
                           dto.setSeatNumber(seat.getSeatNumber());
                           dto.setBooked(seat.isBooked());
                           dto.setScheduleId(seat.getSchedule().getScheduleId());
                           return dto;
                       }).toList();
    }

    @Override
    public List<SeatDto> getAvailableSeatsByScheduleId(int scheduleId) {
        return seatRepo.findBySchedule_ScheduleIdAndIsBookedFalse(scheduleId)
                       .stream()
                       .map(seat -> {
                           SeatDto dto = new SeatDto();
                           dto.setSeatId(seat.getSeatId());
                           dto.setSeatNumber(seat.getSeatNumber());
                           dto.setBooked(seat.isBooked());
                           dto.setScheduleId(seat.getSchedule().getScheduleId());
                           return dto;
                       }).toList();
    }
}
