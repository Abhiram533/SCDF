package com.abhi.processor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

@SpringBootApplication
@EnableBinding(Processor.class)
public class ProcessorApplication {
	private static Logger logger = LoggerFactory.getLogger(ProcessorApplication.class);

	@Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
	public Object transform(Long date) {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Started processing" + dateFormat.format(date));
		return dateFormat.format(date);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProcessorApplication.class, args);
	}

	/*
	 * @Transformer(inputChannel = Processor.INPUT, outputChannel =
	 * Processor.OUTPUT) public List<User> getUppercase(List<User> user) {
	 * logger.info("processor start"); return user; }
	 */
}
