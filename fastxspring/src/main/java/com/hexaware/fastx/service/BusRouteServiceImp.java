package com.hexaware.fastx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.dto.BusRouteDto;
import com.hexaware.fastx.entity.BusOperator;
import com.hexaware.fastx.entity.BusRoute;
import com.hexaware.fastx.repository.BusRouteRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@Transactional
public class BusRouteServiceImp implements IBusRouteService {

    @Autowired
    private BusRouteRepository repo;
    
    private BusRoute mapDtoToEntity(BusRouteDto dto, BusRoute route) {
    
    	
    	route.setRouteId(dto.getRouteId());
    	
    	BusOperator operator=new BusOperator();
    	operator.setOperatorId(dto.getOperatorId());
    	route.setOperatorId(operator);
    	
    	
    	route.setBusName(dto.getBusName());
    	route.setBusType(dto.getBusType());
    	route.setBusNumber(dto.getBusNumber());
    	route.setOrgin(dto.getOrgin());
    	route.setDestination(dto.getDestination());
    	route.setTotalSeats(dto.getTotalSeats());
    	route.setFare(dto.getFare());
    	route.setAmenities(dto.getAmenities());
    	
    	return route;
    }
    
    @Override
    public BusRoute addRoute(BusRouteDto dto) {
        log.info("Adding Bus Route");
    	BusRoute route=mapDtoToEntity(dto, new BusRoute());
    	return repo.save(route); 
    }

    @Override
    public BusRoute updateRoute(BusRouteDto dto) {
    	log.info("Updating Bus Route by Route Id:{}", dto.getRouteId());
    	BusRoute exist=repo.findById(dto.getRouteId()).orElse(null);
    	
        
        if(exist!=null) {
        	exist=mapDtoToEntity(dto, exist);
        	return repo.save(exist); 
        }
        log.warn("No Bus Route found");
        return null;
    }

    @Override
    public List<BusRoute> getAllBusRoute() {
        log.debug("Get All Bus Routes");
    	return repo.findAll();
    }

    @Override
    public List<BusRoute> searchRoute(String orgin, String destination) {
    	log.debug("Search Bus Routes from {} to orgin{}", orgin, destination);
    	return repo.findByOrginAndDestination(orgin, destination);
    }

    @Override
    public String deleteByRouteId(int routeId) {
    	log.debug("Delete Bus Routes by Id:{}", routeId);
    	repo.deleteById(routeId);
        return "BusRoute deleted successfully!";
    }
}
