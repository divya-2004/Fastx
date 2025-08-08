package com.hexaware.fastx.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.entity.Schedule;
import com.hexaware.fastx.repository.ScheduleRepository;

@Service
public class ScheduleServiceImp implements IScheduleService {
	@Autowired
	ScheduleRepository repo;
	
	@Override
	public Schedule addSchedule(Schedule schedule) {
		return repo.save(schedule);
	}
	@Override
	public Schedule getScheduleId(int scheduleId) {
		return repo.findById(scheduleId).orElse(null);
	}
	@Override
	public List<Schedule> getScheduleByRouteId(int routeId){
		return repo.findByRoute_RouteId(routeId);
	}
	@Override
	public List<Schedule> getScheduleByDate(LocalDate departureDate){
		LocalDateTime start=departureDate.atStartOfDay();
		LocalDateTime end=departureDate.atTime(23, 59, 59);
		return repo.findByDepartureTimeBetween(start, end);
	}
	@Override
	public Schedule updateSchedule(Schedule schedule) {
		return repo.save(schedule);
	}
	@Override
	public String deleteSchedule(int scheduleId) {
		repo.deleteById(scheduleId);
		return "Deleted Successfully";
	}

}
