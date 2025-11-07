package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest4;

import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.ArrayList;
import java.util.List;

public class TeethOfTheWind_Solver_Part1
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> gears = new ArrayList<>();
        for (String line : input) {
            gears.add(Integer.valueOf(line));
        }

        Double turns = 1.0;
        for (int i = 0; i < gears.size() - 1; i++) {
            turns *= ((float) gears.get(i) / (float) gears.get(i+1));
        }
        setAnswer(Double.toString(2025 * turns));
//        setAnswer(Long.toString(Math.round(2025 * turns)));

    }
    
}
