package com.sky.learn.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // Minimum threads to keep alive
        executor.setMaxPoolSize(7); // Maximum number of threads
        executor.setQueueCapacity(2); // Queue capacity
        executor.setKeepAliveSeconds(60); // Time before non-core threads are removed
        executor.setThreadNamePrefix("MyExecutor-"); // Naming threads
        executor.initialize();
        return executor;
    }
}
