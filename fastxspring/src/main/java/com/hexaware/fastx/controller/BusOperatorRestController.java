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

import com.hexaware.fastx.entity.BusOperator;
import com.hexaware.fastx.service.IBusOperatorService;

@RestController
@RequestMapping("/api/busoperator")
public class BusOperatorRestController {
	@Autowired
	IBusOperatorService service;
	
	@PostMapping("/add")
	public BusOperator addBusOperator(@RequestBody BusOperator operator) {
		return service.addBusOperator(operator);
	}
	
	@PutMapping("/update")
	public BusOperator updateBusOperator(@RequestBody BusOperator operator) {
		return service.updateBusOperator(operator);
	}
	
	@GetMapping("/getbyid/{operatorid}")
	public BusOperator getBusOperatorById(@PathVariable int operatorId) {
		return service.getByOperatorId(operatorId);
	}
	
	@GetMapping("/getall")
	public List<BusOperator> getAllBusOperator() {
		return service.getAllBusOperator();
	}
	@DeleteMapping("/deletebyid/{operatorid}")
	public String deleteBusOperator(int operatorId) {
		return service.deleteByOperatorId(operatorId);
	}

}
