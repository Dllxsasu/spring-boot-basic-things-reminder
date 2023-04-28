package com.jeremias.dev.loki;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Import(LokiModuleConfiguration.class)
@Configuration
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableLokiModule {
}
