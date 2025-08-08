package com.hexaware.fastx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.entity.BusRoute;
import com.hexaware.fastx.repository.BusRouteRepository;

@Service
public class BusRouteServiceImp implements IBusRouteService {

    @Autowired
    private BusRouteRepository repo;

    @Override
    public BusRoute addRoute(BusRoute route) {
        return repo.save(route); 
    }

    @Override
    public BusRoute updateRoute(BusRoute route) {
        return repo.save(route); 
    }

    @Override
    public List<BusRoute> getAllBusRoute() {
        return repo.findAll();
    }

    @Override
    public List<BusRoute> searchRoute(String orgin, String destination) {
        return repo.findByOrginAndDestination(orgin, destination);
    }

    @Override
    public String deleteByRouteId(int routeId) {
        repo.deleteById(routeId);
        return "BusRoute deleted successfully!";
    }
}
