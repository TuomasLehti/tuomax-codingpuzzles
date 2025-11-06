package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest3;

import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheDeepestFit_Solver_Part3
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        Map<Integer, Integer> crates = parse(input);
        Integer mostRepeats = Integer.MIN_VALUE;
        for (Integer size : crates.keySet()) {
            mostRepeats = Math.max(mostRepeats, crates.get(size));
        }
        setAnswer(mostRepeats.toString());
    }

    private Map<Integer, Integer> parse(List<String> input) 
    {
        Map<Integer, Integer> crates = new HashMap<>();
        String[] parts = input.get(0).split(",");
        for (String part : parts) {
            Integer partAsInt = Integer.valueOf(part);
            crates.put(partAsInt, crates.getOrDefault(partAsInt, 0) + 1);
        }
        return crates;
    }
    
}
