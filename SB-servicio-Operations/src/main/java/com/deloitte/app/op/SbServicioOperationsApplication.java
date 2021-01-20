package com.deloitte.app.op;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.deloitte.app.op.operations.table"})
public class SbServicioOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbServicioOperationsApplication.class, args);
	}

}
