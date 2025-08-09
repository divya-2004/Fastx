package com.hexaware.fastx.service;
import java.time.LocalDate;
import java.util.List;

import com.hexaware.fastx.dto.ScheduleDto;
import com.hexaware.fastx.entity.Schedule;


public interface IScheduleService {
	public Schedule addSchedule(ScheduleDto dto);
	public Schedule getScheduleId(int scheduleId);
	public List<Schedule> getScheduleByRouteId(int routeId);
	public List<Schedule> getScheduleByDate(LocalDate departureDate);
	public Schedule updateSchedule(Schedule schedule);
	public String deleteSchedule(int scheduleId);
}
