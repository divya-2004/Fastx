package com.hexaware.fastx.service;
import java.util.List;

import com.hexaware.fastx.dto.BusOperatorDto;
import com.hexaware.fastx.entity.BusOperator;

public interface IBusOperatorService {
	public BusOperator addBusOperator(BusOperatorDto dto);
	public BusOperator getByOperatorId(int operatorId);
	public List<BusOperator> getAllBusOperator();
	public BusOperator updateBusOperator(BusOperatorDto dto);
	public String deleteByOperatorId(int operatorId);
}
