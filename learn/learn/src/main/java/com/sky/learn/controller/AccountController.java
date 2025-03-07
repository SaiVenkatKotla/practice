package com.sky.learn.controller;

import com.sky.learn.dto.AccountQueryDTO;
import com.sky.learn.dto.AccountsDTO;
import com.sky.learn.dto.AccountsResponseDTO;
import com.sky.learn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountsDTO> getAccountById(@PathVariable String id) {
        return ResponseEntity.ok(accountService.findAccountById(id));
    }

    @PostMapping("/accounts/products")
    public ResponseEntity<AccountsResponseDTO> getProductsByQuery(@RequestBody AccountQueryDTO queryDTO) {
        return ResponseEntity.ok(accountService.findProductsByQuery(queryDTO));
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(String message) {
        return ResponseEntity.ok("Ack");
    }


}
