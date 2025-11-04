package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest1;

import fi.tuomax.codingpuzzles.framework.Solver;
import java.util.List;

public class WhispersInTheShell_Solver_Part2
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        String[] names = input.get(0).split(",");
        String[] instructions = input.get(2).split(",");

        int idx = 0;
        for (String instruction : instructions) {
            char dir = instruction.charAt(0);
            int amount = Integer.valueOf(instruction.substring(1));
            if (dir == 'L')
                idx -= amount;
            if (dir == 'R')
                idx += amount;
        }
        while (idx < 0)
            idx += names.length;
        while (idx > names.length - 1)
            idx -= names.length;
        setAnswer(names[idx]);
    }
    
}
