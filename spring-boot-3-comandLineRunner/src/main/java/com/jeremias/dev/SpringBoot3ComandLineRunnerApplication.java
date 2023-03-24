package com.jeremias.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*CommandLineRunner
 CommandLineRunner is an interface used to indicate that a bean should run when it is 
 contained within a SpringApplication. A Spring Boot application can have multiple beans
  implementing CommandLineRunner. These can be ordered with @Order.


 */
@SpringBootApplication
public class SpringBoot3ComandLineRunnerApplication {

	public static void main(String[] args) {
		System.out.println("The service to start.");
		SpringApplication.run(SpringBoot3ComandLineRunnerApplication.class, args);
		System.out.println("The service has started.");
	}

}
