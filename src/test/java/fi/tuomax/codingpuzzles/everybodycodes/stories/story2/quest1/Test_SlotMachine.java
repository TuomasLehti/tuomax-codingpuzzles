package fi.tuomax.codingpuzzles.everybodycodes.stories.story2.quest1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Test_SlotMachine 
{

    @Test
    public void test()
    {
        List<String> input = Arrays.asList(new String[]{
            "*.*.*.*.*", 
            ".*.*.*.*.", 
            "*...*.*.*", 
            ".*.*...*.", 
            "*.*...*..", 
            ".*.*.*.*."
        });
        SlotMachine machine = new SlotMachine(input);
        assertEquals(3L, machine.dropCoin("RLLRLR", 5L));
        assertEquals(4L, machine.dropCoin("RLLRLR", 4L));
    }
    
}
