package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest3;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.codingpuzzles.framework.Solver;

public class TheConicalSnailClock_Solver_Part2
extends Solver
{

    private List<Snail> snails = new ArrayList<>();

    @Override
    public void solve(List<String> input) 
    {
        parse(input);
        Integer answer = 0;
        while (!fullAlignment(answer, 0)) {
            answer++;
        }
        setAnswer(answer.toString());
    }

    private Boolean fullAlignment(Integer day, Integer snailIdx)
    {
        if (snailIdx.equals(snails.size())) {
            return true;
        }
        if (snails.get(snailIdx).alignsAt(day)) {
            return fullAlignment(day, snailIdx + 1);
        } 
        return false;
    }

    private void parse(List<String> input)
    {
        for (String line : input)
            snails.add(new Snail(line));
    }
    
}
