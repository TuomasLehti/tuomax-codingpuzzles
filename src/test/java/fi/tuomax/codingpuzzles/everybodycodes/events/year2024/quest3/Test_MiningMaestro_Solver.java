package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest3;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_MiningMaestro_Solver 
extends Test_Solver
{
    
    @Test
    public void test_Part1()
    {
        runTest(
            Site.ID_EC, 2024, 2, 0, "part1",
            MiningMaestro_Solver_Part1.class
        );
    }

    @Test
    public void test_Part3()
    {
        runTest(
            Site.ID_EC, 2024, 2, 2, "part3",
            MiningMaestro_Solver_Part3.class
        );
    }

}
