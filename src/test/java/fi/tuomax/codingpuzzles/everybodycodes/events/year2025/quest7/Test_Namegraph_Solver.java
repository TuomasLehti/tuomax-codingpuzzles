package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest7;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_Namegraph_Solver 
extends Test_Solver
{

    private final String SITE = Site.ID_EC;

    private final Integer EVENT = 2025;

    private final Integer DAY = 6;

    @Test
    public void test_Part1() 
    {
        final Integer PART = 0;
        runTest(
            SITE, EVENT, DAY, PART,
            "part1", 
            Namegraph_Solver_Part1.class
        );
    }

    @Test
    public void test_Part2() 
    {
        final Integer PART = 1;
        runTest(
            SITE, EVENT, DAY, PART,
            "part2", 
            Namegraph_Solver_Part2.class
        );    
    }

    @Test
    public void test_Part3() 
    {
        final Integer PART = 2;
        runTest(
            SITE, EVENT, DAY, PART,
            "part3", 
            Namegraph_Solver_Part3.class
        );    
        runTest(
            SITE, EVENT, DAY, PART,
            "part3big", 
            Namegraph_Solver_Part3.class
        );    
    }

}
