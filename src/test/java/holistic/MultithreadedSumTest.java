package holistic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultithreadedSumTest {

    @Test
    void sum_thousand() {
        // given
        Sum sumObj = new MultithreadedSum();

        // when
        long result = sumObj.sum(1_000L);

        // then
        assertEquals(4500L, result);
    }
    @Test
    void sum_million() {
        // given
        Sum sumObj = new MultithreadedSum();

        // when
        long result = sumObj.sum(1_000_000L);

        // then
        assertEquals(4500000L, result);
    }

    @Test
    void sum_billion() {
        // given
        Sum sumObj = new MultithreadedSum();

        // when
        long result = sumObj.sum(1_000_000_000L);

        // then
        assertEquals(4500000000L, result);
    }

}
