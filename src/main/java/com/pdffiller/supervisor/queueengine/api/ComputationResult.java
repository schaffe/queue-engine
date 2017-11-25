package com.pdffiller.supervisor.queueengine.api;

public class ComputationResult {
    private final long channels;
    private final double avgWaitTime;
    private final double queueSize;

    public ComputationResult(double avgWaitTime, long channels, double queueSize) {
        this.avgWaitTime = avgWaitTime;
        this.channels = channels;
        this.queueSize = queueSize;
    }

    public double getAvgWaitTime() {
        return avgWaitTime;
    }

    public long getChannels() {
        return channels;
    }

    public double getQueueSize() {
        return queueSize;
    }
}
