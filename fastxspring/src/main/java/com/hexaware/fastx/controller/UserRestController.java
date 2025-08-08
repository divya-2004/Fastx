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

import com.hexaware.fastx.entity.User;
import com.hexaware.fastx.service.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
	@Autowired
	IUserService service;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		return service.registerUser(user);
	}
	@PostMapping("/login")
	public User loginUser(@RequestParam String email, @RequestParam String password) {
		return service.loginUser(email, password);
	}
	@GetMapping("/getbyid/{userId}")
	public User getUserById(@PathVariable int userId) {
		return service.getUserById(userId);
	}
	@GetMapping("/getall")
	public List<User> getAllUser() {
		return service.getAllUser();
	}
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
	@DeleteMapping("/delete")
	public String deleteUserById(@PathVariable int userId) {
		return service.deleteByUserId(userId);
	}
}
