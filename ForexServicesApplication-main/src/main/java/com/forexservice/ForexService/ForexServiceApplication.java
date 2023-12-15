package com.forexservice.ForexService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = "com.forexservice.ForexService.Controller.AdminAuthenticationController")
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ForexServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForexServiceApplication.class, args);
	}

}
