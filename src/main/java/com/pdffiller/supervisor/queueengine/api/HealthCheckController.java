package com.pdffiller.supervisor.queueengine.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class HealthCheckController {
    @RequestMapping(path = "/health", method = GET)
    public String health() {
        return "ok " + LocalDateTime.now();
    }
}
