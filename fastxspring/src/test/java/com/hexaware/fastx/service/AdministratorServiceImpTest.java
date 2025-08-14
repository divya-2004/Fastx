package com.hexaware.fastx.service;

import com.hexaware.fastx.dto.AdministratorDto;
import com.hexaware.fastx.entity.Administrator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdministratorServiceImpTest {

    @Autowired
    private AdministratorServiceImp administratorService;

    @Test
    @Order(1)
    public void testAddAdmin() {
        AdministratorDto dto = new AdministratorDto();
        dto.setAdminId(1);
        dto.setEmail("admin1@example.com");
        dto.setName("Admin One");
        dto.setPassword("adminpass");

        Administrator savedAdmin = administratorService.addAdmin(dto);
        assertNotNull(savedAdmin);
        assertEquals("Admin One", savedAdmin.getName());
        assertEquals("admin1@example.com", savedAdmin.getEmail());
    }

    @Test
    @Order(2)
    public void testGetByAdminId_Success() {
        Administrator admin = administratorService.getByAdminId(1);
        assertNotNull(admin);
        assertEquals("Admin One", admin.getName());
        assertEquals("admin1@example.com", admin.getEmail());
    }

    @Test
    @Order(3)
    public void testUpdateAdmin() {
        AdministratorDto dto = new AdministratorDto();
        dto.setAdminId(1);
        dto.setEmail("updated.admin@example.com");
        dto.setName("Jane Doe");
        dto.setPassword("newpassword123");

        Administrator updatedAdmin = administratorService.updateAdmin(dto);
        assertNotNull(updatedAdmin);
        assertEquals("Jane Doe", updatedAdmin.getName());
        assertEquals("updated.admin@example.com", updatedAdmin.getEmail());
    }

    @Test
    @Order(4)
    public void testGetAllAdmin() {
        List<Administrator> admins = administratorService.getAllAdmin();
        assertTrue(admins.size() > 0);
    }

    @Test
    @Order(5)
    public void testDeleteByAdminId() {
        String result = administratorService.deleteByAdminId(1);
        assertEquals("Deleted Successfully", result);
        Administrator admin = administratorService.getByAdminId(1);
        assertNull(admin);
    }
}
