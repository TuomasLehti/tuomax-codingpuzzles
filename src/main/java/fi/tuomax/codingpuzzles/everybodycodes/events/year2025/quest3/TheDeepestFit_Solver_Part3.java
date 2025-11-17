package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest3;

import fi.tuomax.codingpuzzles.common.Counter;
import fi.tuomax.codingpuzzles.common.IntegerList;
import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.List;

public class TheDeepestFit_Solver_Part3
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<Integer> crates = IntegerList.fromString(input.get(0), ",");
        Counter<Integer> counter = new Counter<>();
        counter.countAll(crates);
        setAnswer(counter.getMaxAmount());
    }
    
}
