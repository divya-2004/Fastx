package com.hexaware.fastx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.fastx.dto.UserDto;
import com.hexaware.fastx.entity.User;
import com.hexaware.fastx.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private IUserService service;

    @PostMapping("/register")
    public User register(@RequestBody UserDto dto) {
        return service.registerUser(dto);
    }
    @GetMapping("/getbyid/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        User user = service.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = service.getAllUser();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody @Valid UserDto dto) {
        User updatedUser = service.updateUser(dto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable int userId) {
        String result = service.deleteByUserId(userId);
        return ResponseEntity.ok(result);
    }
}
