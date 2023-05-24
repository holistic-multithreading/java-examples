package holistic;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class MultithreadedBenchmark {
    private final Sum sum = new MultithreadedSum();

    @Benchmark
    public void thousand(Blackhole bh) {
        bh.consume(
                sum.sum(1_000)
        );
    }

    @Benchmark
    public void million(Blackhole bh) {
        bh.consume(
                sum.sum(1_000_000)
        );
    }

    @Benchmark
    public void billion(Blackhole bh) {
        bh.consume(
                sum.sum(1_000_000_000)
        );
    }

}
