package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest4;

import fi.tuomax.codingpuzzles.common.IntegerList;
import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.List;

public class TeethOfTheWind_Solver_Part2
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> gears = IntegerList.fromStringCollection(input);

        Double totalRatio = 
            (double) gears.get(0) 
            / (double) gears.get(gears.size() - 1);
        Double inputRotations = 10_000_000_000_000.0 / totalRatio;
        setAnswer(Math.round(Math.ceil(inputRotations)));
    }
    
}
