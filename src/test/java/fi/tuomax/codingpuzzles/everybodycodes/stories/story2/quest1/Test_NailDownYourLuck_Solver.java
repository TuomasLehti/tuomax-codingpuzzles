package fi.tuomax.codingpuzzles.everybodycodes.stories.story2.quest1;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_NailDownYourLuck_Solver 
extends Test_Solver
{

    @Test
    public void test_Part1()
    {
        runTest(
            Site.ID_ECS, 2, 0, 0, "part1", 
            NailDownYourLuck_Solver_Part1.class
        );
    }

    @Test
    public void test_Part2()
    {
        runTest(
            Site.ID_ECS, 2, 0, 1, "part2", 
            NailDownYourLuck_Solver_Part2.class
        );
    }
    
}
