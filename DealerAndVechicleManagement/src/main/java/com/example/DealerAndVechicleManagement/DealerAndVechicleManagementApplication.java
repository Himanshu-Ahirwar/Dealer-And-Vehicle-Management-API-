package com.example.DealerAndVechicleManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class DealerAndVechicleManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(DealerAndVechicleManagementApplication.class, args);
	}

}
