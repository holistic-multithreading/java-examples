package holistic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MultithreadedSum implements Sum {
    private final int cpuCount;

    public MultithreadedSum() {
        cpuCount = Runtime.getRuntime().availableProcessors();
    }

    public MultithreadedSum(int cpuCount) {
        this.cpuCount = cpuCount;
    }

    @Override
    public long sum(long range) {
        long[] sums = new long[cpuCount];
        List<Thread> threads = new ArrayList<>(cpuCount);
        long chunkSize = range / cpuCount;

        IntStream.range(0, cpuCount).forEach(i -> {
            Thread thread = new Thread(() -> {
                long start = chunkSize * i + 1;
                long end = start + chunkSize;
                boolean isLast = i + 1 == cpuCount;
                if (isLast) {
                    end = range;
                }
                long sum = 0;
                for (long x = start; x < end; x++) {
                    sum += x % 10;
                }
                sums[i] = sum;
            });
            thread.start();
            threads.add(thread);
        });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return LongStream.of(sums).sum();
    }
}
