package com.hexaware.fastx.service;
import java.util.List;

import com.hexaware.fastx.entity.BusRoute;

public interface IBusRouteService {
	public BusRoute addRoute(BusRoute route);
	public BusRoute updateRoute(BusRoute route);
	public List<BusRoute> getAllBusRoute();
	public List<BusRoute> searchRoute(String orgin, String destination);
	public String deleteByRouteId(int routeId);
	
}