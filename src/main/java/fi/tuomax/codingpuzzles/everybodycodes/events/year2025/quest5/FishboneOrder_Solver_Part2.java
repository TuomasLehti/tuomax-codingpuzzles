package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest5;

import fi.tuomax.codingpuzzles.common.IntegerList;
import fi.tuomax.codingpuzzles.framework.Solver;
import java.util.List;

public class FishboneOrder_Solver_Part2
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        Long min = Long.MAX_VALUE;
        Long max = Long.MIN_VALUE;
        for (String line : input) {
            Long sword = sword(line);
            min = Math.min(min, sword);
            max = Math.max(max, sword);
        }
        setAnswer(Long.toString(max - min));
    }

    private Long sword(String input)
    {
        List<Integer> numbers = IntegerList.fromString(input.split(":")[1], ",");
        SpineSegment head = new SpineSegment();
        for (Integer num : numbers) {
            head.add(num);
        }
        return Long.valueOf(head.toString());

    }
    
}
