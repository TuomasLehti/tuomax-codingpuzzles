package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Test_Enicode_Solver_Part3
{

    @Test
    public void test_SumTerms()
    {
        EniCode_Solver_Part3 solver = new EniCode_Solver_Part3();
        List<Long> longs = new ArrayList<>(Arrays.asList(new Long[]{0L, 1L, 2L, 3L, 2L}));

//        assertEquals(0, solver.sumTerms(longs, 0));
//        assertEquals(1, solver.sumTerms(longs, 1));
//        assertEquals(3, solver.sumTerms(longs, 2));
//        assertEquals(6, solver.sumTerms(longs, 3));
//        assertEquals(8, solver.sumTerms(longs, 4));
//        assertEquals(11, solver.sumTerms(longs, 5));
/*
        longs = new ArrayList<>(Arrays.asList(new Long[]{0L, 1L, 2L, 3L, 2L}));
        assertEquals(13, solver.sumTerms(longs, 6));
        longs = new ArrayList<>(Arrays.asList(new Long[]{0L, 1L, 2L, 3L, 2L}));
        assertEquals(16, solver.sumTerms(longs, 7));
        longs = new ArrayList<>(Arrays.asList(new Long[]{0L, 1L, 2L, 3L, 2L}));
        assertEquals(18, solver.sumTerms(longs, 8));
        longs = new ArrayList<>(Arrays.asList(new Long[]{0L, 1L, 2L, 3L, 2L}));
        assertEquals(21, solver.sumTerms(longs, 9));
        longs = new ArrayList<>(Arrays.asList(new Long[]{0L, 1L, 2L, 3L, 2L}));
        assertEquals(23, solver.sumTerms(longs, 10));
*/

        longs = new ArrayList<>(Arrays.asList(new Long[]{4L, 16L, 64L, 16L}));
        assertEquals(559940, solver.sumTerms(longs, 14000));

    }

    @Test
    public void test_Eni()
    {
        EniCode_Solver_Part3 solver = new EniCode_Solver_Part3();
//        assertEquals("19", solver.eni(2L, 7L, 5L));
//        assertEquals("48", solver.eni(3L, 8L, 16L));

//        assertEquals("240000", solver.eni(8L, 8000L, 120L));
        assertEquals("559940", solver.eni(4L, 14000L, 120L));
        assertEquals("640000", solver.eni(7L, 16000L, 120L));
    }


    @Test
    public void test_SummedEni()
    {
        EniCode_Solver_Part3 solver = new EniCode_Solver_Part3();
        assertEquals(1573000L, solver.summedEni(4L, 4L, 6L, 3000L, 14000L, 15000L, 110L));
        assertEquals(1439940L, solver.summedEni(8L, 4L, 7L, 8000L, 14000L, 16000L, 120L));
        assertEquals(2079860L, solver.summedEni(2L, 8L, 6L, 2000L, 14000L, 15000L, 130L));
        assertEquals(2407850L, solver.summedEni(5L, 9L, 6L, 8000L, 16000L, 18000L, 140L));
        assertEquals(2099880L, solver.summedEni(5L, 9L, 7L, 6000L, 16000L, 18000L, 150L));
        assertEquals(3279640L, solver.summedEni(8L, 8L, 8L, 6000L, 19000L, 16000L, 160L));
    }

    @Test
    public void test_BigEni()
    {
        EniCode_Solver_Part2 solver = new EniCode_Solver_Part2();

    }


}
