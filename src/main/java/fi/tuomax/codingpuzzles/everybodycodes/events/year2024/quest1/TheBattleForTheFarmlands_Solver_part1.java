package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest1;

import java.util.List;

import fi.tuomax.codingpuzzles.framework.Solver;

public class TheBattleForTheFarmlands_Solver_part1 
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        Integer result = 0;
        for (char c : input.get(0).toCharArray()) {
            switch (c) {
                case 'B' : result += 1; break;
                case 'C' : result += 3; break;
            }
        }
        setAnswer(result.toString());
    }
    
}
