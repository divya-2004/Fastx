package com.hexaware.fastx.service;
import java.util.List;

import com.hexaware.fastx.entity.User;


public interface IUserService {
	public User registerUser(User user);
	public User loginUser(String email, String password);
	public User getUserById(int userId);
	public List<User> getAllUser();
	public User updateUser(User user);
	public String deleteByUserId(int userId);
}
