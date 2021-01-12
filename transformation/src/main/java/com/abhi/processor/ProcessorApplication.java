package com.abhi.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@SpringBootApplication
@EnableTask
public class ProcessorApplication {
	private static Logger logger = LoggerFactory.getLogger(ProcessorApplication.class);
	 
	public static void main(String[] args) {
		SpringApplication.run(ProcessorApplication.class, args);
	}

}
