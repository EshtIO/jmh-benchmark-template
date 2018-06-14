package com.eshtio.lib.jmh.template;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

/**
 * Simple benchmark template with JMH-library using.
 * All measurable methods must be annotated by {@link org.openjdk.jmh.annotations.Benchmark}
 *
 * Parameter {@link org.openjdk.jmh.infra.Blackhole} is consumer of any object. It's passed to the method
 * for JVM optimisation exclusion only
 *
 * Created by EshtIO on 14.06.18.
 */
public class BenchmarkTemplate {

    /**
     * First measurable method example
     */
    @Benchmark
    public void first(Blackhole blackhole) {
        int a = 2 + 2;
        blackhole.consume(a);
    }

    /**
     * Second measurable method example
     */
    @Benchmark
    public void second(Blackhole blackhole) {
        int a = 3 + 3;
        blackhole.consume(a);
    }

}
