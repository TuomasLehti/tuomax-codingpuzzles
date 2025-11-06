package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest3;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_TheDeepestFit_Solver 
extends Test_Solver
{

    @Test
    public void test_Part1() 
    {
        runTest(Site.ID_EC, 2025, 2, 0, "part1", TheDeepestFit_Solver_Part1.class);
    }

    @Test
    public void test_Part2() 
    {
        runTest(Site.ID_EC, 2025, 2, 1, "part2", TheDeepestFit_Solver_Part2.class);
    }

    @Test
    public void test_Part3() 
    {
        runTest(Site.ID_EC, 2025, 2, 2, "part3", TheDeepestFit_Solver_Part3.class);
    }

}
