package com.example.deloitte.controller;


import com.example.deloitte.entity.Registration;
import com.example.deloitte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    UserService userService;

    @PostMapping("/v1/register/user")
    public ResponseEntity<String> registerUser(@RequestBody Registration registration) {
        String result = userService.registerUser(registration);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/get")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Up and Running");
    }
}
