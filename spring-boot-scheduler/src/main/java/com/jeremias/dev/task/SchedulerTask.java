package com.jeremias.dev.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
	private int count=1;

    @Scheduled(cron="*/1 * * * * ?")
    private void process(){
        System.out.println("esta corriendo el contador  "+(count++));
    }
    
}
