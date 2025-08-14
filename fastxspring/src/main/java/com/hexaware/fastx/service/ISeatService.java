package com.hexaware.fastx.service;
import java.util.List;

import com.hexaware.fastx.dto.SeatDto;

public interface ISeatService {
    List<SeatDto> getSeatsByScheduleId(int scheduleId);
    List<SeatDto> getAvailableSeatsByScheduleId(int scheduleId);
}
