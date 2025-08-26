package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Test_Crt 
{

    @Test
    public void testGeneral()
    {
        TheConicalSnailClock_Solver_Part3 solver = new TheConicalSnailClock_Solver_Part3();
        List<Long> as = Arrays.asList(new Long[]{2L, 3L, 2L});
        List<Long> ms = Arrays.asList(new Long[]{3L, 5L, 7L});
        assertEquals(23L, solver.crt(as, ms));
    }

    @Test
    public void testEcs()
    {
        TheConicalSnailClock_Solver_Part3 solver = new TheConicalSnailClock_Solver_Part3();
        List<Long> as = Arrays.asList(new Long[]{4L, 4L, 5L});
        List<Long> ms = Arrays.asList(new Long[]{5L, 7L, 19L});
        assertEquals(214L, solver.crt(as, ms));
    }
    
}
