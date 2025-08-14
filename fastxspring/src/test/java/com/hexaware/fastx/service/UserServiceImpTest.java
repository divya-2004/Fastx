package com.hexaware.fastx.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.fastx.dto.UserDto;
import com.hexaware.fastx.entity.User;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceImpTest {

    @Autowired
    private UserServiceImp userService;

    @Test
    @Order(1)
    public void testRegisterUser() {
        UserDto dto = new UserDto();
        dto.setUserId(1);
        dto.setName("Divya");
        dto.setEmail("divya@example.com");
        dto.setPassword("password123");
        dto.setGender("Female");
        dto.setContactNumber("9876543210");

        User savedUser = userService.registerUser(dto);
        assertNotNull(savedUser);
        assertEquals("Divya", savedUser.getName());
        assertEquals("divya@example.com", savedUser.getEmail());
        assertEquals("Female", savedUser.getGender().toString());
    }

    @Test
    @Order(2)
    public void testGetUserById_Success() {
        User user = userService.getUserById(1);
        assertNotNull(user);
        assertEquals("Divya", user.getName());
        assertEquals("9876543210", user.getContactNumber());
        assertEquals("Female", user.getGender().toString());
    }
}
