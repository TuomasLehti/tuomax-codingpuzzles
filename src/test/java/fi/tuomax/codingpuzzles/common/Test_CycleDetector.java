package fi.tuomax.codingpuzzles.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Test_CycleDetector 
{

    @Test
    public void test_Add_And_CycleDetected()
    {
        RepetitionDetector<Integer> detector = new RepetitionDetector<>();

        detector.add(1);
        assertFalse(detector.repetitionDetected());
        detector.add(2);
        assertFalse(detector.repetitionDetected());
        detector.add(1);
        assertTrue(detector.repetitionDetected());
    }

    @Test
    public void test_GetIntro()
    {
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5, 6, 4};

        RepetitionDetector<Integer> detector = new RepetitionDetector<>();
        for (Integer integer : ints) {
            detector.add(integer);
        }

        Integer[] expected = new Integer[]{1, 2, 3};
        assertArrayEquals(expected, detector.getIntro().toArray());
    }

    @Test
    public void test_GetIntro_WhenNoIntro()
    {
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5, 6, 1};

        RepetitionDetector<Integer> detector = new RepetitionDetector<>();
        for (Integer integer : ints) {
            detector.add(integer);
        }

        assertEquals(0, detector.getIntro().size());
    }

    @Test
    public void test_GetRepetition()
    {
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5, 6, 4};

        RepetitionDetector<Integer> detector = new RepetitionDetector<>();
        for (Integer integer : ints) {
            detector.add(integer);
        }

        Integer[] expected = new Integer[]{4, 5, 6};
        assertArrayEquals(expected, detector.getRepetition().toArray());
    }

    @Test
    public void test_GetOutro()
    {
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5, 6, 4};

        RepetitionDetector<Integer> detector = new RepetitionDetector<>();
        for (Integer integer : ints) {
            detector.add(integer);
        }

        Integer[] expected = new Integer[]{4, 5};
        assertArrayEquals(expected, detector.getOutro(7L).toArray());
    }

    @Test
    public void test_GetOutro_WhenNoOutro()
    {
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5, 6, 4};

        RepetitionDetector<Integer> detector = new RepetitionDetector<>();
        for (Integer integer : ints) {
            detector.add(integer);
        }

        assertEquals(0, detector.getOutro(8L).size());
    }

    @Test
    public void test_GetNumOfRepetitions()
    {
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5, 6, 4};

        RepetitionDetector<Integer> detector = new RepetitionDetector<>();
        for (Integer integer : ints) {
            detector.add(integer);
        }

        assertEquals(1, detector.getNumOfRepetitions(7L));
    }

    @Test
    public void test_GetNumOfRepetitions_WhenNoOutro()
    {
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5, 6, 4};

        RepetitionDetector<Integer> detector = new RepetitionDetector<>();
        for (Integer integer : ints) {
            detector.add(integer);
        }

        assertEquals(2, detector.getNumOfRepetitions(8L));
    }

    @Test
    public void test_Get()
    {
        Integer[] ints = new Integer[]{1, 2, 3, 4, 5, 6, 4};

        RepetitionDetector<Integer> detector = new RepetitionDetector<>();
        for (Integer integer : ints) {
            detector.add(integer);
        }

        assertEquals(1, detector.get(0L));
        assertEquals(2, detector.get(1L));
        assertEquals(3, detector.get(2L));
        assertEquals(4, detector.get(3L));
        assertEquals(5, detector.get(4L));
        assertEquals(6, detector.get(5L));
        assertEquals(4, detector.get(6L));
        assertEquals(5, detector.get(7L));
        assertEquals(6, detector.get(8L));
        assertEquals(4, detector.get(9L));
        assertEquals(5, detector.get(10L));
        assertEquals(6, detector.get(11L));
        
    }
    
}
