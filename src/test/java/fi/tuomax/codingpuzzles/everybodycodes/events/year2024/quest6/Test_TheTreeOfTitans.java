package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest6;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_TheTreeOfTitans
extends Test_Solver
{

    @Test
    public void test_Part1()
    {
        runTest(
            Site.ID_EC, 2024, 5, 0, "part1",
            TheTreeOfTitans_Solver_Part1.class
        );
    }
    
}
