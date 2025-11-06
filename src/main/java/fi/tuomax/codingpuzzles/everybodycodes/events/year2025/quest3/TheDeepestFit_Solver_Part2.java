package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest3;

import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TheDeepestFit_Solver_Part2
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> crates = parse(input);
        setAnswer(sum(crates.subList(0, 20)).toString());
    }

    private Integer sum(List<Integer> ints)
    {
        Integer sum = 0;
        for (Integer i : ints)
            sum += i;
        return sum;
    }

    private List<Integer> parse(List<String> input) 
    {
        Set<Integer> crates = new HashSet<>();
        String[] parts = input.get(0).split(",");
        for (String part : parts)
            crates.add(Integer.valueOf(part));
        List<Integer> orderedCrates = new ArrayList<>(crates);
        Collections.sort(orderedCrates);
        return orderedCrates;
    }
    
}
