package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest1;

import java.util.List;

import fi.tuomax.codingpuzzles.framework.Solver;

public class TheBattleForTheFarmlands_Solver_part2
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        String line = input.get(0);
        Integer result = 0;
        for (int idx = 0; idx < line.length() - 1; idx += 2) {
            String part = line.substring(idx, idx + 2);
            result += getPotions(part.charAt(0)) + getPotions(part.charAt(1));
            if (!part.contains("x")) {
                result += 2;
            }
        }
        setAnswer(result.toString());
    }

    private Integer getPotions(Character enemy)
    {
        switch (enemy) {
            case 'B' : return 1;
            case 'C' : return 3;
            case 'D' : return 5;
        }
        return 0;
    }
    
}
