package com.abhi.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTask
public class ProducerApplication {
	private static Logger logger = LoggerFactory.getLogger(ProducerApplication.class);

	@Bean
	public CommandLineRunner commandLineRunner() {
		return new HelloWorldCommandLineRunner();
	}
	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource")
	public DataSourceProperties memberDataSourceProperties() {
	    return new DataSourceProperties();
	}
	@Bean
	@ConfigurationProperties(prefix="spring.mysql")
	public javax.sql.DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	public static class HelloWorldCommandLineRunner implements CommandLineRunner {

		@Override
		public void run(String... strings) throws Exception {
			System.out.println("Hello, World!");
		}
	}

}
