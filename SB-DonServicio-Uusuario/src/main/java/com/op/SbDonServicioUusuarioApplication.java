package com.op;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.deloitte.app.op.operations.table"})
public class SbDonServicioUusuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbDonServicioUusuarioApplication.class, args);
	}

}
