package tn.sncft.carburantservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CarburantServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CarburantServiceApplication.class, args);
	}

}
