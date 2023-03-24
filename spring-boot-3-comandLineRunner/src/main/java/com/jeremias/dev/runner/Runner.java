package com.jeremias.dev.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
//Se va llamar ultimo dado que no se le asigno un order
@Component
public class Runner implements CommandLineRunner{
	@Override
    public void run(String... args) throws Exception {
        System.out.println("The Runner start to initialize ...");
    }
}
