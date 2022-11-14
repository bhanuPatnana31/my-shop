package com.patnana.myshop.configurations;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsynConfiguration {

	 @Bean (name = "taskExecutor")
	    public Executor taskExecutor() {
	        System.out.print("Creating Async Task Executor");
	        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(2);
	        executor.setMaxPoolSize(2);
	        executor.setQueueCapacity(1000);
	        executor.setThreadNamePrefix("myshopThread-");
	        executor.initialize();
	        return executor;
	    }
}
