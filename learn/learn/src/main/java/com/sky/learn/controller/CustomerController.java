package com.sky.learn.controller;

import com.sky.learn.dto.CustomerResponseDTO;
import com.sky.learn.dto.QueryDTO;
import com.sky.learn.entity.Customer;
import com.sky.learn.serviceimpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> findById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @GetMapping("/customers/email/{email}")
    public ResponseEntity<Customer> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(customerService.findByEmail(email));
    }

    @GetMapping("/customers/username/{username}")
    public ResponseEntity<Customer> findByUsername(@PathVariable String username) {
        return ResponseEntity.ok(customerService.findByUsername(username));
    }

    @GetMapping("/customers/totals/{username}")
    public ResponseEntity<BigDecimal> totalByUsername(@PathVariable String username) {
        return ResponseEntity.ok(customerService.findTotalByUsername(username));
    }

    @PostMapping("/customers/totals")
    public ResponseEntity<CustomerResponseDTO> totalByQuery(@RequestBody QueryDTO queryDTO) {
        return ResponseEntity.ok(customerService.findTotalByQuery(queryDTO));
    }

    @PostMapping("/customers/tier")
    public ResponseEntity<CustomerResponseDTO> getTierAndDetails(@RequestBody QueryDTO queryDTO) {
        return ResponseEntity.ok(customerService.findTierAndDetails(queryDTO));
    }
}
