package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest3;

import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TheDeepestFit_Solver_Part1
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> crates = parse(input);
        setAnswer(sum(crates).toString());
    }

    private String print(List<Integer> ints)
    {
        StringBuilder sb = new StringBuilder();
        for (Integer i : ints) {
            if (sb.length() > 0)
                sb.append(",");
            sb.append(i);
        }
        return sb.toString();
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
