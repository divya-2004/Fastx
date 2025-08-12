package com.hexaware.fastx.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.fastx.dto.UserDto;
import com.hexaware.fastx.entity.User;
import com.hexaware.fastx.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class UserServiceImp implements IUserService {
	@Autowired
	UserRepository userRepo;
	
	private User mapDtoToEntity(UserDto dto, User user) {
		if(user==null) {user=new User();}
		user.setUserId(dto.getUserId());
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setGender(dto.getGender());
		user.setContactNumber(dto.getContactNumber());
		
		return user;
	}
	
	@Override
	public User registerUser(UserDto dto) {
		log.info("Register new user with email:{}", dto.getEmail());
		return userRepo.save(mapDtoToEntity(dto,null));
	}
	@Override
	public User loginUser(String email, String password) {
		log.info("Login with email:{}", email);
		return userRepo.findByEmailAndPassword(email, password);
	}
	@Override
	public User getUserById(int userId) {
		log.debug("Get user by ID:{}",userId);
		return userRepo.findById(userId).orElse(null);
	}
	@Override
	public List<User> getAllUser(){
		log.info("Get all user");
		return userRepo.findAll();
	}
	@Override
	public User updateUser(UserDto dto) {
		log.info("Update user with Id",dto.getUserId());
		User exist=userRepo.findById(dto.getUserId()).orElse(null);
		if(exist!=null) {
			exist=mapDtoToEntity(dto, exist);
			log.debug("User details Updated");
			return userRepo.save(exist);
		}
		log.warn("No user found");
		return null;
		
	}
	@Override
	public String deleteByUserId(int userId) {
		log.info("Delete user by Id:{}",userId);
		userRepo.deleteById(userId);
		return "Deleted Successfully";
	}
}
