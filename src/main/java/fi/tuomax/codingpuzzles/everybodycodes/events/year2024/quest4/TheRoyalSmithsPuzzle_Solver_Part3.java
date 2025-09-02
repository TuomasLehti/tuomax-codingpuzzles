package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest4;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.codingpuzzles.framework.Solver;

public class TheRoyalSmithsPuzzle_Solver_Part3
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
        Integer longest = Integer.MIN_VALUE;
        for (Integer nail : nails) {
            shortest = Math.min(shortest, nail);
            longest = Math.max(longest, nail);
        }

        Integer efficientest = Integer.MAX_VALUE;
        for (int i = shortest; i <= longest; i++) {
            Integer result = 0;
            for (Integer nail : nails) {
                result += Math.abs(nail - i);
            }
            efficientest = Math.min(efficientest, result);
        }

        setAnswer(efficientest.toString());

    }
    
}
