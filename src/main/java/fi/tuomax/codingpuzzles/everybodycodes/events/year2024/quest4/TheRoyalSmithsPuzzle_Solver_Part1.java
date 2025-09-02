package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest4;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.codingpuzzles.framework.Solver;

public class TheRoyalSmithsPuzzle_Solver_Part1 
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> nails = new ArrayList<>();
        for (String line : input) {
            nails.add(Integer.valueOf(line));
        }

        Integer shortest = Integer.MAX_VALUE;
        for (Integer nail : nails) {
            shortest = Math.min(shortest, nail);
        }

        Integer result = 0;
        for (Integer nail : nails) {
            result += nail - shortest;
        }

        setAnswer(result.toString());

    }
    
}
