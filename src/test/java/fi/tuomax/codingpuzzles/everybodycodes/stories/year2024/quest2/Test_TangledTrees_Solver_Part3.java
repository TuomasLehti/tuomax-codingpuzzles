package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest2;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_TangledTrees_Solver_Part3 
extends Test_Solver
{

    @Test
    public void test_Solve()
    {
        runTest(Site.ID_ECS, 1, 1, 2, "part3", TangledTrees_Solver_Part3.class);
    }

    @Test
    public void test_Solve_ExtraSwap()
    {
        runTest(Site.ID_ECS, 1, 1, 2, "part3ExtraSwap", TangledTrees_Solver_Part3.class);
    }
    
}
