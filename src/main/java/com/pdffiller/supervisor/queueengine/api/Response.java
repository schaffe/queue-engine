package com.pdffiller.supervisor.queueengine.api;

import java.util.List;

public class Response {
    private final List<ComputationResult> result;
    private final long time;

    public Response(List<ComputationResult> result, long time) {
        this.result = result;
        this.time = time;
    }

    public List<ComputationResult> getResult() {
        return result;
    }

    public long getTime() {
        return time;
    }
}
