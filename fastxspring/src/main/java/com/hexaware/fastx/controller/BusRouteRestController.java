package com.hexaware.fastx.controller;

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

import com.hexaware.fastx.dto.BusRouteDto;
import com.hexaware.fastx.entity.BusRoute;
import com.hexaware.fastx.service.IBusRouteService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/busroute")
public class BusRouteRestController {
	@Autowired
	IBusRouteService service;
	
	@PostMapping("/add")
	public BusRoute addBusRoute(@RequestBody  @Valid BusRouteDto dto) {
		log.info("REST API called: Add new Bus Route");
		return service.addRoute(dto);
	}
	@PutMapping("/update")
	public BusRoute updateBusRoute(@RequestBody  @Valid BusRouteDto dto) {
		log.info("REST API called: Update Bus Route", dto);
		return service.updateRoute(dto);
	}
	@GetMapping("/getall")
	public List<BusRoute> getAllBusRoute(){
		log.debug("REST API called: Get all Bus Route");
		return service.getAllBusRoute();
	}
	@GetMapping("/search/{orgin}/{destination}")
	public List<BusRoute> searchBusRoute(@PathVariable String orgin, @PathVariable String destination){
		log.debug("REST API called: Search Bus Route");
		return service.searchRoute(orgin, destination);
	}
	@DeleteMapping("/deletebyid/{routeId}")
	public String deleteBusRoute(@PathVariable int routeId) {
		log.warn("REST API called: Delete Bus Route by Id", routeId);
		return service.deleteByRouteId(routeId);
	}
	
}
