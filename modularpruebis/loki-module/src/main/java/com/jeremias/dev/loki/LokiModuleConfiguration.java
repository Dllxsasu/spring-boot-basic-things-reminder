package com.jeremias.dev.loki;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@Configuration
@Log4j2
@ComponentScan(basePackages = "com.jeremias.dev.loki")
public class LokiModuleConfiguration {

    @PostConstruct
    public void postConstruct(){
        log.info("LOKI MODULE LOADED, is going Crazy!");
    }

}
