package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest1;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_TheBattleForTheFarmlands_Solver 
extends Test_Solver
{

    @Test
    public void test_Part2() 
    {
        runTest(Site.ID_EC, 2025, 0, 1, "part2", WhispersInTheShell_Solver_Part2.class);
    }

}
