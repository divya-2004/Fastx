package com.hexaware.fastx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx.dto.AdministratorDto;
import com.hexaware.fastx.entity.Administrator;
import com.hexaware.fastx.service.IAdministratorService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

/**
 * Admin Controller 
 * @author Divya
 * Modified: 14/08/2025
 * add admin
 * update admin
 * getall admin
 * getbyid admin
 * delete admin
 */

@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdministratorRestController {
	@Autowired
	IAdministratorService service;
	
	@PostMapping("/add")
	@PreAuthorize("hasAnyRole('Admin')")
	public Administrator addAdmin(@RequestBody @Valid AdministratorDto dto) {
		log.info("REST API called: Add new admin");
		return service.addAdmin(dto);
	}
	
	@PutMapping("/update")
	@PreAuthorize("hasAnyRole('Admin')")
	public Administrator updateAdmin(@RequestBody @Valid AdministratorDto dto) {
		log.info("REST API called: Update admin by ID:{}");
		return service.updateAdmin(dto);
	}
	
	@GetMapping("/getbyid/{adminId}")
	@PreAuthorize("hasAnyRole('Admin')")
	public Administrator getAdminById(@PathVariable int adminId) {
		log.info("REST API called: Get admin by ID:{}");
		return service.getByAdminId(adminId);
	}
	
	@GetMapping("/getall")
	@PreAuthorize("hasAnyRole('Admin')")
	public List<Administrator> getAllAdmin(){
		log.info("REST API called: Get all admin");
		return service.getAllAdmin();
	}
	
	@DeleteMapping("/deletebyid/{adminId}")
	@PreAuthorize("hasAnyRole('Admin')")
	public String deleteAdminById (@PathVariable int adminId) {
		log.info("REST API called: Delete admin by ID:{}");
		return service.deleteByAdminId(adminId);
	}
	//http://localhost:8085/swagger-ui/index.html

}