package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_NotFastButFurious
extends Test_Solver
{

    @Test
    public void test_Part1()
    {
        runTest(
            Site.ID_EC, 2024, 6, 0, "part1",
            NotFastButFurious_Solver_Part1.class
        );
    }

    @Test
    public void test_ParseTrack()
    {
        String[] ex_trk_inp = new String[]{
            "S+===",
            "-   +",
            "=+=-+",
        };
        NotFastButFurious_Solver_Part2 solver = new NotFastButFurious_Solver_Part2();
        assertEquals("S+===++-=+=-", solver.parseTrack(ex_trk_inp));
    }

    @Test
    public void test_Part2()
    {

    }
    
}
