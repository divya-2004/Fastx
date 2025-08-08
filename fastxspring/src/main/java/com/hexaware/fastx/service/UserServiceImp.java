package com.hexaware.fastx.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.entity.User;
import com.hexaware.fastx.repository.UserRepository;

@Service
public class UserServiceImp implements IUserService {
	@Autowired
	UserRepository userRepo;
	
	@Override
	public User registerUser(User user) {
		return userRepo.save(user);
	}
	@Override
	public User loginUser(String email, String password) {
		return userRepo.findByEmailAndPassword(email, password);
	}
	@Override
	public User getUserById(int userId) {
		return userRepo.findById(userId).orElse(null);
	}
	@Override
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}
	@Override
	public String deleteByUserId(int userId) {
		userRepo.deleteById(userId);
		return "Deleted Successfully";
	}
}
