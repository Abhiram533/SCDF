package com.abhi.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.abhi.consumer.DAO.Final_Repo;
import com.abhi.consumer.model.TakaraDB;

@SpringBootApplication
@EnableBinding(Sink.class)
public class ConsumerApplication {

	private static Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);
	@Autowired
	private Final_Repo repo;

	@StreamListener(Sink.INPUT)
	public void loggerSink(String date) {

		TakaraDB user = new TakaraDB();

		logger.info(date);
		user.setUserName(date);

		repo.save(user);

		logger.info("save completed");
		logger.info("Received: " + date);
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
	/*
	 * @StreamListener(Sink.INPUT) public void display(List<User> user) {
	 * logger.info("Consumer started"); logger.info(user.toString()); }
	 */

}
