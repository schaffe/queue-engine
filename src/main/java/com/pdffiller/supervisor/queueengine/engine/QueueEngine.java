package com.pdffiller.supervisor.queueengine.engine;

import com.pdffiller.supervisor.queueengine.api.ComputationResult;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Math.pow;
import static java.util.stream.Collectors.toList;

public class QueueEngine {

    public static List<ComputationResult> computeFull(double la, double processTime, int maxChannels) {
        return IntStream.rangeClosed(1, maxChannels)
                .boxed()
                .filter(n -> canCompute(n, processTime, la))
                .map(n -> computeOne(n, processTime, la))
                .collect(toList());
    }

    static boolean canCompute(int n, double tP, double la) {
        double ro = la * tP;
        return ro / n < 1;
    }

    static ComputationResult computeOne(int n, double tP, double la) {
        double ro = la * tP;

        if(ro / n > 1)
            throw new IllegalStateException("Tickets in the queue come faster than channels can process");

        double[] p = probabilities(n, ro);

        double queueSize = (pow(ro, n + 1) * p[0] * n) / (fact(n) * pow(n - ro, 2));
        double waitTime = queueSize / la;
        return new ComputationResult(waitTime, n, queueSize);
    }

    static double sum(double[] arr) {
        double sum = 0;
        for (double el : arr) {
            sum += el;
        }
        return sum;
    }

    static double[] probabilities(int n, double ro) {
        double[] p = new double[n + 1];
        p[0] = p0(n, ro);
        for (int i = 1; i <= n; i++) {
            p[i] = ro * p[i - 1] / fact(i);
        }
        return p;
    }

    static double p0(int n, double ro) {
        double sum = 1;
        for (int i = 1; i < n; i++) {
            double step = pow(ro, i) / fact(i);
            sum += step;
        }
        sum += pow(ro, n) / fact(n - 1) / (n - ro);
        return 1 / sum;
    }

    static long fact(long n) {
        if (n < 0)
            throw new IllegalArgumentException("" + n);
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
