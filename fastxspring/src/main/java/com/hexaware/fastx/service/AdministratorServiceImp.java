package com.hexaware.fastx.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.dto.AdministratorDto;
import com.hexaware.fastx.entity.Administrator;
import com.hexaware.fastx.repository.AdministratorRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 * Admin Service
 * @author Divya
 * Modified: 09/08/2025
 * 
 * 
 *
 */

@Slf4j
@Service
@Transactional
public class AdministratorServiceImp implements IAdministratorService{
	@Autowired
	AdministratorRepository repo;
	
	@Override
	public Administrator addAdmin(AdministratorDto dto) {
		log.info("Service Layer: Adding Administrator");
		
		Administrator admin= new Administrator();
		admin.setAdminId(dto.getAdminId());
		admin.setEmail(dto.getEmail());
		admin.setName(dto.getName());
		admin.setPassword(dto.getPassword());
		
		return repo.save(admin);
	}
	@Override
	public Administrator updateAdmin(AdministratorDto dto) {
		log.info("Service Layer: Updating Administrator");
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
		log.debug("Service Layer: Fectch Administrator by ID: {}", adminId);
		return repo.findById(adminId).orElse(null);
	}
	@Override
	public String deleteByAdminId(int adminId) {
		log.warn("Service Layer: Delete Administrator by ID: {}", adminId);
		
		repo.deleteById(adminId);
		return "Deleted Successfully";
	}
	@Override
	public List<Administrator> getAllAdmin(){
		log.debug("Service Layer: Fectch All Administrators");
		return repo.findAll();
	}
}
