package fi.tuomax.codingpuzzles.everybodycodes.events.year2024.quest2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fi.tuomax.codingpuzzles.framework.Solver;

public class TheRunesOfPower_Solver_Part2 
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        List<String> words = Arrays.asList(input.get(0).split(":")[1].split(","));
        input.remove(0);
        input.remove(0);

        Integer answer = 0;
        for (String text : input) {
            Set<Integer> runeIdxs = new HashSet<>();
            for (String word : words) {
                for (int idx = 0; idx < text.length(); idx++) {
                    String drow = new StringBuilder(word).reverse().toString();
                    if (text.startsWith(word, idx) || text.startsWith(drow, idx)) {
                        for (int jdx = 0; jdx < word.length(); jdx++) {
                            runeIdxs.add(idx + jdx);
                        }
                    }
                }
            }
            answer += runeIdxs.size();
        }
        setAnswer(answer.toString());
    }

}
