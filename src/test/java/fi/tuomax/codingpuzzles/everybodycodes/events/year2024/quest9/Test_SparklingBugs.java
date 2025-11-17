package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest9;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_SparklingBugs
extends Test_Solver
{

    private final String SITE = Site.ID_EC;

    private final Integer EVENT = 2024;

    private final Integer DAY = 9 - 1;

    @Test
    public void test_Part1() 
    {
        final Integer PART = 0;
        runTest(
            SITE, EVENT, DAY, PART,
            "part1", 
            SparklingBugs_Solver_Part1.class
        );
    }

    @Test
    public void test_Part2() 
    {
        final Integer PART = 1;
        runTest(
            SITE, EVENT, DAY, PART,
            "part2", 
            SparklingBugs_Solver_Part2.class
        );    
    }

    @Test
    public void test_Part3() 
    {
        final Integer PART = 0;
        runTest(
            SITE, EVENT, DAY, PART,
            "part3", 
            SparklingBugs_Solver_Part3.class
        );    
    }

}
