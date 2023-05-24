package holistic;

public class SingleThreadSum implements Sum {
    @Override
    public long sum(long range) {
        long sum = 0;
        for (long i = 0; i<=range; i++) {
            sum += i % 10;
        }
        return sum;
    }
}
