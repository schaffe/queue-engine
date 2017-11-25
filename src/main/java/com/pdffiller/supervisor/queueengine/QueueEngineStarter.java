package com.pdffiller.supervisor.queueengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class QueueEngineStarter {
    public static void main(String[] args) {
        SpringApplication.run(QueueEngineStarter.class, args);
    }
}
