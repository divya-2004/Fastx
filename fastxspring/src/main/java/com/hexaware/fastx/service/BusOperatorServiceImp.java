package com.hexaware.fastx.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.dto.BusOperatorDto;
import com.hexaware.fastx.entity.BusOperator;
import com.hexaware.fastx.repository.BusOperatorRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 * Bus Operator Service
 * @author Divya
 * Modified: 09/08/2025
 * 
 * 
 *
 */

@Slf4j
@Transactional
@Service
public class BusOperatorServiceImp implements IBusOperatorService{
	@Autowired
	BusOperatorRepository operatorRepo;
	
	public BusOperator mapDtoToEntity(BusOperatorDto dto) {
		BusOperator operator=new BusOperator();
		operator.setOperatorId(dto.getOperatorId());
		operator.setName(dto.getName());
		operator.setEmail(dto.getEmail());
		operator.setPassword(dto.getPassword());
		operator.setContactNumber(dto.getContactNumber());
	
		
		return operatorRepo.save(operator);
	}
	

	@Override
	public BusOperator addBusOperator(BusOperatorDto dto) {
		log.info("Add new Bus Operator");
		BusOperator operator=mapDtoToEntity(dto);
		return operatorRepo.save(operator);
	}

	@Override
	public BusOperator updateBusOperator(BusOperatorDto dto) {
		log.info("Update Bus Operator by Id");
		BusOperator exist=operatorRepo.findById(dto.getOperatorId()).orElse(null);
		if(exist!=null) {
			exist=mapDtoToEntity(dto);
			return operatorRepo.save(exist);
		}return null;
	
	}
	
	@Override 
	public BusOperator getByOperatorId(int operatorId) {
		log.debug("Get Bus Operator by Id: {}",operatorId);
		return operatorRepo.findById(operatorId).orElse(null);
	}
	@Override
	public List<BusOperator> getAllBusOperator(){
		log.debug("Get all Bus Operators");
		return operatorRepo.findAll();
	}
	
	@Override
	public String deleteByOperatorId(int operatorId) {
		log.info("Delete Bus Operator By Id:{}", operatorId);
		operatorRepo.deleteById(operatorId);
		return "Deleted Successfully";
	}

}
