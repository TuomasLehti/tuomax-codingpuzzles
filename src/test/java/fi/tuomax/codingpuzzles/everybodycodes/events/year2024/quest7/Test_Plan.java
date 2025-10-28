package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Test_Plan 
{

    @Test
    public void test()
    {
        Plan plan = new Plan("A:+,-,=,=");
        assertEquals(103, plan.race(10));
    }
    
}
