package com.hexaware.fastx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.fastx.dto.PaymentDto;
import com.hexaware.fastx.entity.Payment;
import com.hexaware.fastx.service.IPaymentService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/payment")
public class PaymentRestController {

    @Autowired
    private IPaymentService service;

    @PostMapping("/make")
    public Payment makePayment(@RequestBody @Valid PaymentDto dto) {
        log.info("REST API called: Make Payment");
        return service.makePayment(dto);
    }

    @GetMapping("/getbyid/{paymentId}")
    public Payment getPaymentById(@PathVariable int paymentId) {
        log.info("REST API called: Get Payment by Id: {}", paymentId);
        return service.getPaymentByPaymentId(paymentId);
    }

    @GetMapping("/getbybooking/{bookingId}")
    public List<Payment> getPaymentByBooking(@PathVariable int bookingId) {
        log.info("REST API called: Get Payment by Booking Id: {}", bookingId);
        return service.getPaymentByBookingId(bookingId);
    }

    @GetMapping("/getall")
    public List<Payment> getAllPayment() {
        log.info("REST API called: Get All Payment");
        return service.getAllPayment();
    }

    @PutMapping("/refund/{paymentId}")
    public String refundPayment(@PathVariable int paymentId) {
        log.info("REST API called: Refund Payment by Id: {}", paymentId);
        return service.refundPayment(paymentId);
    }
}

