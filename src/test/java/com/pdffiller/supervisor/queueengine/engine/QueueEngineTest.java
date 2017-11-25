package com.pdffiller.supervisor.queueengine.engine;

import org.junit.Test;

import static com.pdffiller.supervisor.queueengine.engine.QueueEngine.*;
import static org.junit.Assert.assertEquals;

public class QueueEngineTest {

    @Test
    public void testTimeWait() {
        assertEquals(1.40, computeOne(3, 1, 150d/60).getAvgWaitTime(), 0.01);
//        assertEquals(0.89, computeOne(2, 2, 0.8).getAvgWaitTime(), 0.001);
    }

    @Test
    public void testProbabilities() {
        double[] p = probabilities(2, 1.6);
        assertEquals(3, p.length);
        assertEquals(0.111, p[0], 0.001);
        assertEquals(0.178, p[1], 0.001);
        assertEquals(0.142, p[2], 0.001);
    }

    @Test
    public void testSum() {
        double[] p = probabilities(2, 1.6);
        assertEquals(0.431, sum(p), 0.001);
    }

    @Test
    public void testProb0() {
        assertEquals(0.111, p0(2, 1.6), 0.001);
        assertEquals(0.044, p0(3, 150d/60), 0.001);
    }

    @Test
    public void testFact() {
        assertEquals(1, fact(0));
        assertEquals(1, fact(1));
        assertEquals(2, fact(2));
        assertEquals(6, fact(3));
        assertEquals(24, fact(4));
    }


}