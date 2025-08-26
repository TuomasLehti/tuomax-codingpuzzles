package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest1;

import org.junit.jupiter.api.Test;

import fi.tuomax.codingpuzzles.Test_Solver;
import fi.tuomax.codingpuzzles.metadata.Site;

public class Test_TheBattleForTheFarmlands_Solver 
extends Test_Solver
{

    @Test
    public void test_Part1() 
    {
        runTest(Site.ID_EC, 2024, 0, 0, "part1", TheBattleForTheFarmlands_Solver_part1.class);
    }

    @Test
    public void test_Part2() 
    {
        runTest(Site.ID_EC, 2024, 0, 1, "part2", TheBattleForTheFarmlands_Solver_part2.class);
    }

    @Test
    public void test_Part3() 
    {
        runTest(Site.ID_EC, 2024, 0, 2, "part3", TheBattleForTheFarmlands_Solver_part3.class);
    }
    
}
