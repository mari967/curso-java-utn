package com.mc.questionados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) 
public class QuestionadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionadosApplication.class, args);
	}

}
