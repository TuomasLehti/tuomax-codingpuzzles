package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Test_Plan 
{

    @Test
    public void test_race()
    {
        Plan plan = new Plan("A:+,-,=,=");
        assertEquals(103, plan.race(10));
    }

    @Test
    public void test_loop()
    {
        Plan planA = new Plan("A:+,-,=,=");
        assertEquals(1290, planA.loop("S+===++-=+=-", 10));

        Plan planB = new Plan("A:+,=,-,+");
        assertEquals(3640, planB.loop("S+===++-=+=-", 10));

        Plan planC = new Plan("A:=,-,+,+");
        assertEquals(3700, planC.loop("S+===++-=+=-", 10));

        Plan planD = new Plan("A:=,=,=,+");
        assertEquals(4280, planD.loop("S+===++-=+=-", 10));

    }
   
}
