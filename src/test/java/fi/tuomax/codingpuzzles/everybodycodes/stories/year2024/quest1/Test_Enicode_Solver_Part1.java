package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Test_Enicode_Solver_Part1 
{

    @Test
    public void test_Eni()
    {
        EniCode_Solver_Part1 solver = new EniCode_Solver_Part1();
        assertEquals("1342", solver.eni(2, 4, 5));
        assertEquals("311193", solver.eni(3, 5, 16));
    }

    @Test
    public void test_SummedEni()
    {
        EniCode_Solver_Part1 solver = new EniCode_Solver_Part1();
        assertEquals(114644L, solver.summedEni(4, 4, 6, 3, 4, 5, 11));
        assertEquals(48661009L, solver.summedEni(8, 4, 7, 8, 4, 6, 12));
        assertEquals(313276L, solver.summedEni(2, 8, 6, 2, 4, 5, 13));
        assertEquals(11611972920L, solver.summedEni(5, 9, 6, 8, 6, 8, 14));
        assertEquals(1240513421L, solver.summedEni(5, 9, 7, 6, 6, 8, 15));
        assertEquals(24L, solver.summedEni(8, 8, 8, 6, 9, 6, 16));
    }
}
