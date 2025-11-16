package fi.tuomax.codingpuzzles.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Test_IntegerList 
{

    @Test
    public void test_fromString()
    {
        List<Integer> ints = IntegerList.fromString("1,2,3,4,-5,-6", ",");
        assertEquals(6, ints.size());
        assertEquals(1, (int) ints.get(0));
        assertEquals(2, (int) ints.get(1));
        assertEquals(3, (int) ints.get(2));
        assertEquals(4, (int) ints.get(3));
        assertEquals(-5, (int) ints.get(4));
        assertEquals(-6, (int) ints.get(5));
    }

    @Test
    public void test_removeDuplicates()
    {
        List<Integer> ints = IntegerList.fromString("1,2,3,2,3,4", ",");
        List<Integer> uniqueInts = IntegerList.removeDuplicates(ints);
        assertEquals(4, uniqueInts.size());
    }

    @Test
    public void test_Sum()
    {
        List<Integer> ints = IntegerList.fromString("1,2,3,2,3,4", ",");
        assertEquals(15, (long) IntegerList.sum(ints));
    }
    
}
