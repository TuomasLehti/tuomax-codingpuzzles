package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest2;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_TangledTrees_Solver_Part1 
extends Test_Solver
{

    @Test
    public void test_Solve_Simple()
    {
        runTest(Site.ID_ECS, 1, 1, 0, "part1Simple", TangledTrees_Solver_Part1.class);
    }

    @Test
    public void test_Solve_Complex()
    {
        runTest(Site.ID_ECS, 1, 1, 0, "part1Complex", TangledTrees_Solver_Part1.class);
    }
    
}
