package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Test_Enicode_Solver_Part2
{

    @Test
    public void test_Eni()
    {
        EniCode_Solver_Part2 solver = new EniCode_Solver_Part2();
        assertEquals("34213", solver.eni(2L, 7L, 5L));
        assertEquals("111931", solver.eni(3L, 8L, 16L));
    }

    @Test
    public void test_RepeatEni()
    {
        EniCode_Solver_Part2 solver = new EniCode_Solver_Part2();
        assertEquals("44444", solver.eni(4L, 14L, 12L));
        assertEquals("10510510", solver.eni(5L, 6L, 15L));
    }

    @Test
    public void test_GetTerm()
    {
        EniCode_Solver_Part2 solver = new EniCode_Solver_Part2();
        List<Long> longs = Arrays.asList(new Long[]{0L, 1L, 2L});

        assertEquals(0, solver.getTerm(longs, 0L));
        assertEquals(1, solver.getTerm(longs, 1L));
        assertEquals(2, solver.getTerm(longs, 2L));
        assertEquals(0, solver.getTerm(longs, 3L));
        assertEquals(1, solver.getTerm(longs, 4L));
        assertEquals(2, solver.getTerm(longs, 5L));
        assertEquals(0, solver.getTerm(longs, 6L));
        assertEquals(1, solver.getTerm(longs, 7L));
        assertEquals(2, solver.getTerm(longs, 8L));
    }

    @Test
    public void test_SummedEni()
    {
        EniCode_Solver_Part2 solver = new EniCode_Solver_Part2();
        assertEquals(150231L, solver.summedEni(4L, 4L, 6L, 3L, 14L, 15L, 11L));
        assertEquals(110099L, solver.summedEni(8L, 4L, 7L, 8L, 14L, 16L, 12L));
        assertEquals(9387665L, solver.summedEni(2L, 8L, 6L, 2L, 14L, 15L, 13L));
        assertEquals(1113198L, solver.summedEni(5L, 9L, 6L, 8L, 16L, 18L, 14L));
        assertEquals(11051340L, solver.summedEni(5L, 9L, 7L, 6L, 16L, 18L, 15L));
        assertEquals(0L, solver.summedEni(8L, 8L, 8L, 6L, 19L, 16L, 16L));
    }

    @Test
    public void test_BigEni()
    {
        EniCode_Solver_Part2 solver = new EniCode_Solver_Part2();

    }


}
