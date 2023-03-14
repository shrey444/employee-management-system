package com.shrey.Employee;

import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@NoArgsConstructor
public class EmployeeSystemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSystemApiApplication.class, args);
	}

}
