package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest1;

import java.util.List;

import fi.tuomax.codingpuzzles.framework.Solver;

public class TheBattleForTheFarmlands_Solver_part3
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        String line = input.get(0);
        Integer result = 0;
        for (int idx = 0; idx < line.length() - 2; idx += 3) {
            String part = line.substring(idx, idx + 3);
            result += getPotions(part.charAt(0)) + getPotions(part.charAt(1)) + getPotions(part.charAt(2));
            if (numOfXs(part).equals(0)) {
                result += 6;
            } else if (numOfXs(part).equals(1)) {
                result += 2;
            }
        }
        setAnswer(result.toString());
    }

    private Integer numOfXs(String part)
    {
        Integer result = 0;
        for (Character c : part.toCharArray()) {
            if (c == 'x') {
                result++;
            }
        }
        return result;
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
