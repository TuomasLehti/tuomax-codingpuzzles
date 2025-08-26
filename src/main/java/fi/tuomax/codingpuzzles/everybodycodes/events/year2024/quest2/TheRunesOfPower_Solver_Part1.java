package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest2;

import java.util.Arrays;
import java.util.List;

import fi.tuomax.codingpuzzles.framework.Solver;

public class TheRunesOfPower_Solver_Part1 
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<String> words = Arrays.asList(input.get(0).split(":")[1].split(","));
        String text = input.get(2);

        Integer answer = 0;
        for (String word : words) {
            for (int idx = 0; idx < text.length(); idx++) {
                if (text.startsWith(word, idx)) {
                    answer++;
                }
            }
        }
        setAnswer(answer.toString());
    }

}
