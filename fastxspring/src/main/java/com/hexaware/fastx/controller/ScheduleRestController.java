package com.hexaware.fastx.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx.dto.ScheduleDto;
import com.hexaware.fastx.entity.Schedule;
import com.hexaware.fastx.service.IScheduleService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/schedule")
public class ScheduleRestController {
	@Autowired
	IScheduleService service;
	
	@PostMapping("/add")
	public Schedule addSchedule(@RequestBody @Valid ScheduleDto dto) {
		log.info("REST API called: Add New Schedule");
		return service.addSchedule(dto);
	}
	
	@PutMapping("/update")
	public Schedule updateSchedule(@RequestBody Schedule schedule) {
		log.info("REST API called: Upadte Schedule");
		return service.updateSchedule(schedule);
	}
	
	@DeleteMapping("/deletebyid/{scheduleId}")
	public String deleteSchedule(@PathVariable int scheduleId) {
		log.info("REST API called: Delete Schedule by Id:{}",scheduleId);
		return service.deleteSchedule(scheduleId);
	}
	
	@GetMapping("/getbyid/{scheduleId}")
	public Schedule getScheduleById(@PathVariable int scheduleId) {
		log.info("REST API called: Get Schedule by Id:{}",scheduleId);
		return service.getScheduleId(scheduleId);
	}
	
	@GetMapping("/getbyroute/{routeId}")
	public List<Schedule> getScheduleByRoute(@PathVariable int routeId){
		log.info("REST API called: Get Schedule by route Id:{}",routeId);
		return service.getScheduleByRouteId(routeId);
	}
	
	@GetMapping("/getbydate/{date}")
	public List<Schedule> getScheduleByDate(@PathVariable String date){
		log.info("REST API called: Get Schedule by Date:{}",date);
		LocalDate departureDate= LocalDate.parse(date);
		return service.getScheduleByDate(departureDate);
	}
}
