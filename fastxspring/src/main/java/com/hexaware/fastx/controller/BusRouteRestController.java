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

import com.hexaware.fastx.entity.BusRoute;
import com.hexaware.fastx.service.IBusRouteService;

@RestController
@RequestMapping("/api/busroute")
public class BusRouteRestController {
	@Autowired
	IBusRouteService service;
	
	@PostMapping("/add")
	public BusRoute addBusRoute(@RequestBody BusRoute route) {
		return service.addRoute(route);
	}
	@PutMapping("/update")
	public BusRoute updateBusRoute(@RequestBody BusRoute route) {
		return service.updateRoute(route);
	}
	@GetMapping("/getall")
	public List<BusRoute> getAllBusRoute(){
		return service.getAllBusRoute();
	}
	@GetMapping("/search/{orgin}/{destination}")
	public List<BusRoute> searchBusRoute(@PathVariable String orgin, @PathVariable String destination){
		return service.searchRoute(orgin, destination);
	}
	@DeleteMapping("/deletebyid/{routeId}")
	public String deleteBusRoute(@PathVariable int routeId) {
		return service.deleteByRouteId(routeId);
	}
	
}
