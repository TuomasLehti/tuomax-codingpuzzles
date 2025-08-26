package fi.tuomax.codingpuzzles.everybodycodes.stories.year2024.quest3;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.codingpuzzles.framework.Solver;

public class TheConicalSnailClock_Solver_Part1 
extends Solver
{

    private List<Snail> snails = new ArrayList<>();

    @Override
    public void solve(List<String> input) 
    {
        parse(input);
        Integer answer = 0;
        for (Snail snail : snails) {
            answer += snail.position(100);
        }
        setAnswer(answer.toString());
    }

    private void parse(List<String> input)
    {
        for (String line : input)
            snails.add(new Snail(line));
    }
    
}
