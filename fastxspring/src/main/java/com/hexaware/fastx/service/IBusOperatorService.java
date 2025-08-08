package com.hexaware.fastx.service;
import java.util.List;

import com.hexaware.fastx.entity.BusOperator;

public interface IBusOperatorService {
	public BusOperator addBusOperator(BusOperator operator);
	public BusOperator getByOperatorId(int operatorId);
	public List<BusOperator> getAllBusOperator();
	public BusOperator updateBusOperator(BusOperator operator);
	public String deleteByOperatorId(int operatorId);
}
