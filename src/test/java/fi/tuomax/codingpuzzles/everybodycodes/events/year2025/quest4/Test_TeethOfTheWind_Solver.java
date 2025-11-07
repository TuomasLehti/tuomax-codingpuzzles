package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest4;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_TeethOfTheWind_Solver 
extends Test_Solver
{

    @Test
    public void test_Part1() 
    {
        runTest(
            Site.ID_EC, 
            2025, 
            3, 
            0, 
            "part1_whole", 
            TeethOfTheWind_Solver_Part1.class
        );
        runTest(
            Site.ID_EC, 
            2025, 
            3, 
            0, 
            "part1_fraction", 
            TeethOfTheWind_Solver_Part1.class
        );
    }

    @Test
    public void test_Part2() 
    {
        runTest(
            Site.ID_EC, 
            2025, 
            3, 
            1, 
            "part2_whole", 
            TeethOfTheWind_Solver_Part2.class
        );
        runTest(
            Site.ID_EC, 
            2025, 
            3, 
            1, 
            "part2_fraction", 
            TeethOfTheWind_Solver_Part2.class
        );
    }

    @Test
    public void test_Part3() 
    {
        runTest(
            Site.ID_EC, 2025, 3, 3, 
            "part3_small", 
            TeethOfTheWind_Solver_Part3.class
        );
        runTest(
            Site.ID_EC, 2025, 3, 3, 
            "part3_big", 
            TeethOfTheWind_Solver_Part3.class
        );
    }

}
