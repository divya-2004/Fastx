package com.hexaware.fastx.service;

import com.hexaware.fastx.dto.BusOperatorDto;
import com.hexaware.fastx.entity.BusOperator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BusOperatorServiceImpTest {

    @Autowired
    private BusOperatorServiceImp busOperatorService;

    @Test
    @Order(1)
    public void testAddBusOperator() {
        BusOperatorDto dto = new BusOperatorDto();
        dto.setOperatorId(1);
        dto.setName("FastX Travel");
        dto.setEmail("contact@fastx.com");
        dto.setPassword("password123");
        dto.setContactNumber("9876543210");

        BusOperator savedOperator = busOperatorService.addBusOperator(dto);
        assertNotNull(savedOperator);
        assertEquals("FastX Travel", savedOperator.getName());
        assertEquals("contact@fastx.com", savedOperator.getEmail());
    }

    @Test
    @Order(2)
    public void testGetByOperatorId_Success() {
        BusOperator operator = busOperatorService.getByOperatorId(1);
        assertNotNull(operator);
        assertEquals("FastX Travel", operator.getName());
        assertEquals("9876543210", operator.getContactNumber());
    }

    @Test
    @Order(3)
    public void testUpdateBusOperator() {
        BusOperatorDto dto = new BusOperatorDto();
        dto.setOperatorId(1);
        dto.setName("FastX Express");
        dto.setEmail("support@fastx.com");
        dto.setPassword("newpassword123");
        dto.setContactNumber("9123456789");

        BusOperator updatedOperator = busOperatorService.updateBusOperator(dto);
        assertNotNull(updatedOperator);
        assertEquals("FastX Express", updatedOperator.getName());
        assertEquals("support@fastx.com", updatedOperator.getEmail());
    }

    @Test
    @Order(4)
    public void testGetAllBusOperator() {
        List<BusOperator> operators = busOperatorService.getAllBusOperator();
        assertTrue(operators.size() > 0);
    }

    @Test
    @Order(5)
    public void testDeleteByOperatorId() {
        String result = busOperatorService.deleteByOperatorId(1);
        assertEquals("Deleted Successfully", result);
        BusOperator operator = busOperatorService.getByOperatorId(1);
        assertNull(operator);
    }
}
