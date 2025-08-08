package com.hexaware.fastx.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.entity.BusOperator;
import com.hexaware.fastx.repository.BusOperatorRepository;

@Service
public class BusOperatorServiceImp implements IBusOperatorService{
	@Autowired
	BusOperatorRepository repo;
	
	@Override
	public BusOperator addBusOperator(BusOperator operator) {
		return repo.save(operator);
	}
	@Override 
	public BusOperator getByOperatorId(int operatorId) {
		return repo.findById(operatorId).orElse(null);
	}
	@Override
	public List<BusOperator> getAllBusOperator(){
		return repo.findAll();
	}
	
	@Override
	public BusOperator updateBusOperator(BusOperator operator) {
		return repo.save(operator);
	}
	@Override
	public String deleteByOperatorId(int operatorId) {
		repo.deleteById(operatorId);
		return "Deleted Successfully";
	}
	
	
}
