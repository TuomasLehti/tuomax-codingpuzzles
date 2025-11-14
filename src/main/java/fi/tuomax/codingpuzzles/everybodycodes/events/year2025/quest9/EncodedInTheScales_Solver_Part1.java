package fi.tuomax.codingpuzzles.everybodycodes.events.year2025.quest9;

import fi.tuomax.codingpuzzles.framework.Solver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncodedInTheScales_Solver_Part1
extends Solver
{

    @Override
    public void solve(List<String> input) 
    {
        Map<Integer, String> dna = new HashMap<>();
        for (String line : input)
            dna.put(
                Integer.valueOf(line.split(":")[0]),
                line.split(":")[1]
            );

        int ans = 0;
        if (isChildOf(dna.get(1), dna.get(2), dna.get(3))) {
            ans = similarity(dna.get(1), dna.get(2)) * similarity(dna.get(1), dna.get(3));
        } else if (isChildOf(dna.get(2), dna.get(1), dna.get(3))) {
            ans = similarity(dna.get(2), dna.get(1)) * similarity(dna.get(2), dna.get(3));
        } else if (isChildOf(dna.get(3), dna.get(2), dna.get(1))) {
            ans = similarity(dna.get(3), dna.get(1)) * similarity(dna.get(3), dna.get(2));
        }
        setAnswer(Integer.toString(ans));
    }

    private boolean isChildOf(String child, String mom, String dad)
    {
        for (int i = 0; i < child.length(); i++) {
            char symC = child.charAt(i);
            char symM = mom.charAt(i);
            char symD = dad.charAt(i);
            if (symC != symM && symC != symD)
                return false;
        }
        return true;
    }

    private int similarity(String child, String parent)
    {
        int similarity = 0;
        for (int i = 0; i < child.length(); i++) 
            if (child.charAt(i) == parent.charAt(i))
                similarity++;
        return similarity;
    }
    
}
