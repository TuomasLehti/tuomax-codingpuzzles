package fi.tuomax.codingpuzzles.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Test_Counter 
{

    @Test
    public void test_count()
    {
        Counter<Integer> counter = new Counter<>();
        counter.count(0);
        counter.count(0);
        counter.count(1);
        counter.count(2);
        counter.count(2);
        counter.count(3);
        counter.count(3);
        counter.count(3);
        counter.count(-4);
        counter.count(-5);
        assertEquals(2L, counter.getAmount(0));
        assertEquals(1L, counter.getAmount(1));
        assertEquals(2L, counter.getAmount(2));
        assertEquals(3L, counter.getAmount(3));
        assertEquals(1L, counter.getAmount(-4));
        assertEquals(1L, counter.getAmount(-5));
    }

    @Test
    public void test_countAll()
    {
        List<Integer> ints = Arrays.asList(
            new Integer[]{0, 0, 1, 2, 2, 3, 3, 3, -4, -5}
        );
        Counter<Integer> counter = new Counter<>();
        counter.countAll(ints);
        assertEquals(2L, counter.getAmount(0));
        assertEquals(1L, counter.getAmount(1));
        assertEquals(2L, counter.getAmount(2));
        assertEquals(3L, counter.getAmount(3));
        assertEquals(1L, counter.getAmount(-4));
        assertEquals(1L, counter.getAmount(-5));
    }

    @Test
    public void test_maxAmount()
    {
        List<Integer> ints = Arrays.asList(
            new Integer[]{0, 0, 1, 2, 2, 3, 3, 3, -4, -5}
        );
        Counter<Integer> counter = new Counter<>();
        counter.countAll(ints);
        assertEquals(3L, counter.getMaxAmount());
    }   
    
}
