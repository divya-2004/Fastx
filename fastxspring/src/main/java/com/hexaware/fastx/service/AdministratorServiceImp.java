package com.hexaware.fastx.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.dto.AdministratorDto;
import com.hexaware.fastx.entity.Administrator;
import com.hexaware.fastx.repository.AdministratorRepository;

@Service
public class AdministratorServiceImp implements IAdministratorService{
	@Autowired
	AdministratorRepository repo;
	
	@Override
	public Administrator addAdmin(AdministratorDto dto) {
		Administrator admin= new Administrator();
		admin.setAdminId(dto.getAdminId());
		admin.setEmail(dto.getEmail());
		admin.setName(dto.getName());
		admin.setPassword(dto.getPassword());
		
		return repo.save(admin);
	}
	@Override
	public Administrator updateAdmin(AdministratorDto dto) {
		Administrator admin=repo.findById(dto.getAdminId()).orElse(null);
		if(admin!=null) {
			admin.setAdminId(dto.getAdminId());
			admin.setEmail(dto.getEmail());
			admin.setName(dto.getName());
			admin.setPassword(dto.getPassword());
			
			
			return repo.save(admin);
		}
		
		
		return null;
	}
	
	@Override
	public Administrator getByAdminId(int adminId) {
		return repo.findById(adminId).orElse(null);
	}
	@Override
	public String deleteByAdminId(int adminId) {
		repo.deleteById(adminId);
		return "Deleted Successfully";
	}
	@Override
	public List<Administrator> getAllAdmin(){
		return repo.findAll();
	}
}
