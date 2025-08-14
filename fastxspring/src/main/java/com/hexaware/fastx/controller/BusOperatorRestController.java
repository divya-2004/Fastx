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

import com.hexaware.fastx.dto.BusOperatorDto;
import com.hexaware.fastx.entity.BusOperator;
import com.hexaware.fastx.service.IBusOperatorService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/busoperator")
public class BusOperatorRestController {
	@Autowired
	IBusOperatorService service;
	
	@PostMapping("/add")
	public BusOperator addBusOperator(@RequestBody  @Valid BusOperatorDto dto) {
		log.info("REST API called: Add new Bus Operator");
		return service.addBusOperator(dto);
	}
	
	@PutMapping("/update")
	public BusOperator updateBusOperator(@RequestBody @Valid BusOperatorDto dto) {
		log.info("REST API called: Update Bus Operator by Id: {}", dto);
		return service.updateBusOperator(dto);
	}
	
	@GetMapping("/getbyid/{operatorid}")
	public BusOperator getBusOperatorById(@PathVariable int operatorId) {
		log.info("REST API called: Get Bus Operator by Id", operatorId);
		return service.getByOperatorId(operatorId);
	}
	
	@GetMapping("/getall")
	public List<BusOperator> getAllBusOperator() {
		log.debug("REST API called: Get all Bus Operator");
		return service.getAllBusOperator();
	}
	@DeleteMapping("/deletebyid/{operatorid}")
	public String deleteBusOperator(int operatorId) {
		log.warn("REST API called: Delete Bus Operator by Id", operatorId);
		return service.deleteByOperatorId(operatorId);
	}

}