package com.jeremias.dev.application;

import com.jeremias.dev.loki.EnableLokiModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLokiModule
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
