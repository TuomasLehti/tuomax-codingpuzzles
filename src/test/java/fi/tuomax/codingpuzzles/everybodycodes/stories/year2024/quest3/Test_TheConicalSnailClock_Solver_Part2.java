package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest3;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_TheConicalSnailClock_Solver_Part2
extends Test_Solver
{

    @Test
    public void test_Solve_Sooner()
    {
        runTest(Site.ID_ECS, 1, 2, 1, "part2Sooner", TheConicalSnailClock_Solver_Part2.class);
    }

    @Test
    public void test_Solve_Later()
    {
        runTest(Site.ID_ECS, 1, 2, 1, "part2Later", TheConicalSnailClock_Solver_Part2.class);
    }

}
