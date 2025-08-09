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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx.dto.UserDto;
import com.hexaware.fastx.entity.User;
import com.hexaware.fastx.service.IUserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserRestController {
	@Autowired
	IUserService service;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody @Valid UserDto dto) {
		log.info("REST API called: Register new user");
		return service.registerUser(dto);
	}
	@PostMapping("/login")
	public User loginUser(@RequestParam String email, @RequestParam String password) {
		log.info("REST API called: Login by Email, Password");
		return service.loginUser(email, password);
	}
	@GetMapping("/getbyid/{userId}")
	public User getUserById(@PathVariable int userId) {
		log.info("REST API called: Get user by ID:{}");
		return service.getUserById(userId);
	}
	@GetMapping("/getall")
	public List<User> getAllUser() {
		log.info("REST API called: Get all users");
		return service.getAllUser();
	}
	@PutMapping("/update")
	public User updateUser(@RequestBody @Valid UserDto dto) {
		log.info("REST API called: Update User");
		return service.updateUser(dto);
	}
	@DeleteMapping("/delete")
	public String deleteUserById(@PathVariable int userId) {
		log.info("REST API called: Delete user by ID:{}");
		return service.deleteByUserId(userId);
	}
}
