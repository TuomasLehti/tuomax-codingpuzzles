package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_Enicode_Solver_Part1 
extends Test_Solver
{

    @Test
    public void test_Eni()
    {
        EniCode_Solver_Part1 solver = new EniCode_Solver_Part1();
        assertEquals(1342, solver.eni(2L, 4L, 5L));
        assertEquals(311193, solver.eni(3L, 5L, 16L));
    }

    @Test
    public void test_Solve()
    {
        runTest(Site.ID_ECS, 1, 0, 0, "part1", EniCode_Solver_Part1.class);
    }

}
