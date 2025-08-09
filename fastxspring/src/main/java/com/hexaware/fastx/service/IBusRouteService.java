package com.hexaware.fastx.service;
import java.util.List;

import com.hexaware.fastx.dto.BusRouteDto;
import com.hexaware.fastx.entity.BusRoute;

import jakarta.validation.Valid;

public interface IBusRouteService {
	public BusRoute addRoute(BusRouteDto dto);
	public BusRoute updateRoute(@Valid BusRouteDto dto);
	public List<BusRoute> getAllBusRoute();
	public List<BusRoute> searchRoute(String orgin, String destination);
	public String deleteByRouteId(int routeId);
	
}