package com.jeremias.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootPackingWarJarProfilesApplication extends SpringBootServletInitializer{
	  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SpringBootPackingWarJarProfilesApplication.class);
	    }
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPackingWarJarProfilesApplication.class, args);
	}

}
