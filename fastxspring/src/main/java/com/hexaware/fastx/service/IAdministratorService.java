package com.hexaware.fastx.service;
import java.util.List;

import com.hexaware.fastx.dto.AdministratorDto;
import com.hexaware.fastx.entity.Administrator;

public interface IAdministratorService {
	public Administrator addAdmin(AdministratorDto dto);
	public Administrator updateAdmin(AdministratorDto dto);
	
	public Administrator getByAdminId(int adminId);
	public String deleteByAdminId(int adminId);
	
	public List<Administrator> getAllAdmin();
	
	
}

