package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_Enicode_Solver_Part3
extends Test_Solver
{

    @Test
    public void test_Eni()
    {
        EniCode_Solver_Part3 solver = new EniCode_Solver_Part3();
        assertEquals(19, solver.eni(2L, 7L, 5L));
        assertEquals(48, solver.eni(3L, 8L, 16L));
        assertEquals(559940, solver.eni(4L, 14000L, 120L));
        assertEquals(640000, solver.eni(7L, 16000L, 120L));
    }

    @Test
    public void test_Solve_Small()
    {
        runTest(Site.ID_ECS, 1, 0, 2, "part3Small", EniCode_Solver_Part3.class);
    }

    @Test
    public void test_Solve_Big()
    {
        runTest(Site.ID_ECS, 1, 0, 2, "part3Big", EniCode_Solver_Part3.class);
    }


}
