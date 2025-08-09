package com.hexaware.fastx.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.dto.ScheduleDto;
import com.hexaware.fastx.entity.BusRoute;
import com.hexaware.fastx.entity.Schedule;
import com.hexaware.fastx.repository.BusRouteRepository;
import com.hexaware.fastx.repository.ScheduleRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ScheduleServiceImp implements IScheduleService {
	@Autowired
	ScheduleRepository repo;
	
	@Autowired
	BusRouteRepository routeRepo;
	
	
	@Override
	public Schedule addSchedule(ScheduleDto dto) {
		Schedule schedule=new Schedule();
		schedule.setScheduleId(dto.getScheduleId());
		schedule.setArrivalTime(dto.getArrivalTime());
		schedule.setDepartureTime(dto.getDepartureTime());
		
		BusRoute route=routeRepo.findById(dto.getRouteId()).orElse(null);
		schedule.setRoute(route);
		
		schedule.setAvailableSeats(dto.getAvailableSeats());
		
		return repo.save(schedule);
	}
	@Override
	public Schedule getScheduleId(int scheduleId) {
		log.info("Get Schedule by Id:{}",scheduleId);
		return repo.findById(scheduleId).orElse(null);
	}
	@Override
	public List<Schedule> getScheduleByRouteId(int routeId){
		log.info("Get Schedule by route Id:{}",routeId);
		return repo.findByRoute_RouteId(routeId);
	}
	@Override
	public List<Schedule> getScheduleByDate(LocalDate departureDate){
		log.info("Get Schedule by Date:{}",departureDate);
		LocalDateTime start=departureDate.atStartOfDay();
		LocalDateTime end=departureDate.atTime(23, 59, 59);
		return repo.findByDepartureTimeBetween(start, end);
	}
	@Override
	public Schedule updateSchedule(Schedule schedule) {
		log.info("Updating Schedule");
		return repo.save(schedule);
	}
	@Override
	public String deleteSchedule(int scheduleId) {
		log.warn("Delete Schedule by Id:{}",scheduleId);
		repo.deleteById(scheduleId);
		return "Deleted Successfully";
	}

}
