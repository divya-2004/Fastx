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

import com.hexaware.fastx.dto.AdministratorDto;
import com.hexaware.fastx.entity.Administrator;
import com.hexaware.fastx.service.IAdministratorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class AdministratorRestController {
	@Autowired
	IAdministratorService service;
	
	@PostMapping("/add")
	public Administrator addAdmin(@RequestBody @Valid AdministratorDto dto) {
		return service.addAdmin(dto);
	}
	
	@PutMapping("/update")
	public Administrator updateAdmin(@RequestBody @Valid AdministratorDto dto) {
		return service.updateAdmin(dto);
	}
	
	@GetMapping("/getbyid/{adminId}")
	public Administrator getAdminById(@PathVariable int adminId) {
		return service.getByAdminId(adminId);
	}
	
	@GetMapping("/getall")
	public List<Administrator> getAllAdmin(){
		return service.getAllAdmin();
	}
	
	@DeleteMapping("/deletebyid/{adminId}")
	public String deleteAdminById (@PathVariable int adminId) {
		return service.deleteByAdminId(adminId);
	}
	

}
