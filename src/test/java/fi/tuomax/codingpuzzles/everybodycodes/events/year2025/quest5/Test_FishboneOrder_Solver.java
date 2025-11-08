package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_FishboneOrder_Solver 
extends Test_Solver
{

    private final String SITE = Site.ID_EC;

    private final Integer EVENT = 2025;

    private final Integer DAY = 4;

    @Test
    public void test_Part1() 
    {
        final Integer PART = 0;
        runTest(
            SITE, EVENT, DAY, PART,
            "part1", 
            FishboneOrder_Solver_Part1.class
        );
    }

    @Test
    public void test_Part2() 
    {
        final Integer PART = 1;
        runTest(
            SITE, EVENT, DAY, PART,
            "part2", 
            FishboneOrder_Solver_Part2.class
        );    }


    @Test
    public void test_Compare()
    {
        Sword one = new Sword("1:5,3,7,8,1,10,9,5,7,8");
        Sword other = new Sword("2:5,3,7,8,1,10,9,4,7,9");
        assertTrue(one.compareTo(other) > 0);
    }

    @Test
    public void test_Compare_Identcal()
    {
        Sword one = new Sword("1:7,1,9,1,6,9,8,3,7,2");
        Sword other = new Sword("2:7,1,9,1,6,9,8,3,7,2");
        assertTrue(one.compareTo(other) < 0);
    }

    @Test
    public void test_Part3() 
    {
        final Integer PART = 0;
        runTest(
            SITE, EVENT, DAY, PART,
            "part3", 
            FishboneOrder_Solver_Part3.class
        );    
    }

}
