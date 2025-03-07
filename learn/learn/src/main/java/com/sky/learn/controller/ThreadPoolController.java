package com.sky.learn.controller;


import com.sky.learn.service.ThreadPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thread")
public class ThreadPoolController {

    @Autowired
    ThreadPoolService poolService;

    @GetMapping("/start")
    public ResponseEntity<String> startTheThread() {
        poolService.executeThread();
        return ResponseEntity.ok("Thread Started ");
    }
}
