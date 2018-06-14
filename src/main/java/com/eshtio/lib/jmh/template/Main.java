package com.eshtio.lib.jmh.template;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Main class for JMH benchmark running
 *
 * @see <a href=http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples>More jmh samples</a>
 *
 * Created by EshtIO on 14.06.18.
 */
public class Main {

    /**
     * Benchmark classes list with measurable methods
     * annotated by {@link org.openjdk.jmh.annotations.Benchmark}
     */
    private static final List<Class<?>> BENCHMARK_CLASSES = Arrays.asList(
            BenchmarkTemplate.class
    );

    public static void main(String[] args) {
        try {
            new Runner(prepareJmhOptions(args)).run();
        } catch (RunnerException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * JMH options build method
     *
     * @param args jvm arguments
     * @return {@link org.openjdk.jmh.runner.options.Options}
     */
    private static Options prepareJmhOptions(String[] args) {
        ChainedOptionsBuilder builder = new OptionsBuilder()
                .jvmArgs(args)
                .warmupTime(TimeValue.seconds(10))
                .warmupIterations(10)
                .warmupForks(2)
                .forks(2)
                .threads(10)
                .measurementTime(TimeValue.seconds(10))
                .timeUnit(TimeUnit.MILLISECONDS)
                .mode(Mode.SampleTime);

        BENCHMARK_CLASSES.stream()
                .map(Class::getName)
                .forEach(builder::include);

        return builder.build();
    }

}
