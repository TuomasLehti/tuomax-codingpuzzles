package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Test_Node 
{

    @Test
    public void test_Creation()
    {
        Node[] nodes = Node.fromEcsInput("ADD id=1 left=[10,A] right=[30,H]");
        assertEquals(1, nodes[0].getId());
        assertEquals(10, nodes[0].getRank());
        assertEquals("A", nodes[0].getSymbol());
        assertEquals(1, nodes[1].getId());
        assertEquals(30, nodes[1].getRank());
        assertEquals("H", nodes[1].getSymbol());
    }
    
}
