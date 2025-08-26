package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_Enicode_Solver_Part2
extends Test_Solver
{

    @Test
    public void test_Eni()
    {
        EniCode_Solver_Part2 solver = new EniCode_Solver_Part2();
        assertEquals(34213, solver.eni(2L, 7L, 5L));
        assertEquals(111931, solver.eni(3L, 8L, 16L));
    }

    @Test
    public void test_Solve_S()
    {
        runTest(Site.ID_ECS, 1, 0, 1, "part2Small", EniCode_Solver_Part2.class);
    }

    @Test
    public void test_Solve_B()
    {
        runTest(Site.ID_ECS, 1, 0, 1, "part2Big", EniCode_Solver_Part2.class);
    }


}
