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

    @Test
    public void test_Intersects()
    {
        Chord one = new Chord(1, 4);
        assertTrue(one.intersects(new Chord(2, 5)));
        assertTrue(one.intersects(new Chord(2, 6)));
        assertTrue(one.intersects(new Chord(2,7)));
        assertTrue(one.intersects(new Chord(2, 8)));
        assertTrue(one.intersects(new Chord(3, 5)));
        assertTrue(one.intersects(new Chord(3, 6)));
        assertTrue(one.intersects(new Chord(3,7)));
        assertTrue(one.intersects(new Chord(3, 8)));
        assertFalse(one.intersects(new Chord(5, 6)));
        assertFalse(one.intersects(new Chord(5, 7)));
        assertFalse(one.intersects(new Chord(5, 1)));
        assertFalse(one.intersects(new Chord(2, 4)));

        one = new Chord(3, 7);
        assertTrue(one.intersects(new Chord(2, 6)));
        assertTrue(one.intersects(new Chord(1, 6)));
        assertTrue(one.intersects(new Chord(8, 6)));
        assertFalse(one.intersects(new Chord(2, 8)));
    }
    
}
