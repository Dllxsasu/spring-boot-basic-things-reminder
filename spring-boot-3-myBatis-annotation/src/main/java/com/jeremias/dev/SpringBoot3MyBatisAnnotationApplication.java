package com.jeremias.dev;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.jeremias.dev.mapper")
@SpringBootApplication
public class SpringBoot3MyBatisAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3MyBatisAnnotationApplication.class, args);
	}

}
