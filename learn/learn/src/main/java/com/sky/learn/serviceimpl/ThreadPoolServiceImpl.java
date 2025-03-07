package com.sky.learn.serviceimpl;

import com.sky.learn.service.ThreadPoolService;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ThreadPoolServiceImpl implements ThreadPoolService {


    @Async("threadPoolTaskExecutor")
    @Override
    public void executeThread() {
        System.out.println("Executing task on thread: " + Thread.currentThread().getName() + " Started" );
        try {
            Thread.sleep(20000); // Simulating some work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Executing task on thread: " + Thread.currentThread().getName()+ " Ended" );
    }
}
