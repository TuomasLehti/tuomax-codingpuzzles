package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest5;

import fi.tuomax.codingpuzzles.common.IntegerList;
import fi.tuomax.codingpuzzles.framework.Solver;
import java.util.List;

public class FishboneOrder_Solver_Part1
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> numbers = IntegerList.fromString(input.get(0).split(":")[1], ",");
        SpineSegment head = new SpineSegment();
        for (Integer num : numbers) {
            head.add(num);
        }
        setAnswer(head.toString());
    }
    
}
