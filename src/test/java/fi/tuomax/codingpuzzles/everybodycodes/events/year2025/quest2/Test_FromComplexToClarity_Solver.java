package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_FromComplexToClarity_Solver 
extends Test_Solver
{

    @Test
    public void test_Part1() 
    {
        runTest(Site.ID_EC, 2025, 1, 0, "part1", FromComplexToClarity_Solver_Part1.class);
    }

    @Test
    public void test_IsEngraved()
    {
        FromComplexToClarity_Solver_Part2_Part3 solver = new FromComplexToClarity_Solver_Part2_Part3();
        
        assertTrue(solver.isEngraved(new Complex(35630,-64880)));
        assertTrue(solver.isEngraved(new Complex(35630,-64780)));
        assertTrue(solver.isEngraved(new Complex(35640,-64860)));
        assertTrue(solver.isEngraved(new Complex(36230,-64270)));
        assertTrue(solver.isEngraved(new Complex(36250,-64270)));

        assertFalse(solver.isEngraved(new Complex(35460,-64910)));
        assertFalse(solver.isEngraved(new Complex(35470,-64910)));
        assertFalse(solver.isEngraved(new Complex(35480,-64910)));
        assertFalse(solver.isEngraved(new Complex(35680,-64850)));
        assertFalse(solver.isEngraved(new Complex(35630,-64830)));
    }

    @Test
    public void test_Part2() 
    {
        runTest(Site.ID_EC, 2025, 1, 1, "part2", FromComplexToClarity_Solver_Part2_Part3.class);
    }

    @Test
    public void test_Part3() 
    {
        runTest(Site.ID_EC, 2025, 1, 2, "part3", FromComplexToClarity_Solver_Part2_Part3.class);
    }

}
