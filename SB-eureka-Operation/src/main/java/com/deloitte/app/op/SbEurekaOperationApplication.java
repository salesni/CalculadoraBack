package com.deloitte.app.op;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SbEurekaOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbEurekaOperationApplication.class, args);
	}

}
