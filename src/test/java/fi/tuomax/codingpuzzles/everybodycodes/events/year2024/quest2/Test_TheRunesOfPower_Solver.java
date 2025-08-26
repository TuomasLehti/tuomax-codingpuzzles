package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest2;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_TheRunesOfPower_Solver 
extends Test_Solver
{

    @Test
    public void test_Part1()
    {
        runTest(
            Site.ID_EC, 2024, 1, 0, "part1",
            TheRunesOfPower_Solver_Part1.class
        );
    }

    @Test
    public void test_Part2()
    {
        runTest(
            Site.ID_EC, 2024, 1, 1, "part2",
            TheRunesOfPower_Solver_Part2.class
        );
    }

    @Test
    public void test_Part3()
    {
        runTest(
            Site.ID_EC, 2024, 1, 2, "part3",
            TheRunesOfPower_Solver_Part3.class
        );
    }
    
}
