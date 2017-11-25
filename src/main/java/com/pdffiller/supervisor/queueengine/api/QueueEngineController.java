package com.pdffiller.supervisor.queueengine.api;

import com.pdffiller.supervisor.queueengine.engine.QueueEngine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/engine")
public class QueueEngineController {

    @GetMapping
    public Response compute(@RequestParam int tickets,
                            @RequestParam double consumeTime,
                            @RequestParam(defaultValue = "1") int timeFrameDuration,
                            @RequestParam(defaultValue = "HOURS") String timeFrameUnit,
                            @RequestParam(defaultValue = "10") int maxChannels) {
        long time = System.currentTimeMillis();
        double loadAverage = (double) tickets / TimeUnit.valueOf(timeFrameUnit.toUpperCase()).toMinutes(timeFrameDuration);
        List<ComputationResult> computationResults = QueueEngine.computeFull(loadAverage, consumeTime, maxChannels);
        return new Response(computationResults, System.currentTimeMillis() - time);
    }
}
