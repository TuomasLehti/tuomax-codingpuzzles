package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest3;

import fi.tuomax.codingpuzzles.common.IntegerList;
import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.Collections;
import java.util.List;

public class TheDeepestFit_Solver_Part1
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> crates = IntegerList.removeDuplicates(
            IntegerList.fromString(input.get(0), ",")
        );
        Collections.sort(crates);
        setAnswer(IntegerList.sum(crates));
    }
    
}
