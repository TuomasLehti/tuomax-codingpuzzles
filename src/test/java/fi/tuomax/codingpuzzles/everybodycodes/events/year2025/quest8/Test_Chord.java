package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest8;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Test_Chord 
{

    @Test
    public void test_IsDiameter()
    {
        assertTrue(new Chord(1, 5).isDiameter());
        assertTrue(new Chord(6, 2).isDiameter());
        assertFalse(new Chord(3, 5).isDiameter());
        assertFalse(new Chord(5, 2).isDiameter());
    }
    
}
